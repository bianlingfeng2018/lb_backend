package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.BalanceMapper;
import com.libiao.customer.dal.mapper.ClientBillOutMapper;
import com.libiao.customer.dal.mapper.TestQuotationMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.model.bill.BillIncomeAddReq;
import com.libiao.customer.model.bill.BillOutAddReq;
import com.libiao.customer.model.bill.BillOutReq;
import com.libiao.customer.model.bill.ClientBillOutVo;
import com.libiao.customer.model.enums.BillStatus;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.service.BillOutService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BillOutServiceImpl implements BillOutService {

    @Autowired
    private ClientBillOutMapper outMapper;

    @Autowired
    BillIncomeService incomeService;

    @Autowired
    BalanceService balanceService;

    @Autowired
    TestQuotationMapper quotationMapper;

    @Autowired
    private BalanceMapper balanceMapper;


    @Override
    public ResponseEntity<ListResponseVO<ClientBillOutVo>> getAllOutBill(BillOutReq req) {
        PageHelper.startPage(req.getPage(), req.getPageSize());
        ClientBillOutExample example = new ClientBillOutExample();
        ClientBillOutExample.Criteria criteria = example.createCriteria();
        if (!StringUtils.isEmpty( req.getClientId())) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (!StringUtils.isEmpty( req.getStatus())) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andStartTimeBetween(req.getStartTime(), req.getEndTime());
        }
        if (null != req.getLastStartTime() && null != req.getLastEndTime()) {
            criteria.andLastTimeBetween(req.getLastStartTime(), req.getLastEndTime());
        }
        example.setOrderByClause("last_time DESC");
        List<ClientBillOut> list = outMapper.selectByExample(example);
        PageInfo<ClientBillOut> pageInfo = new PageInfo<ClientBillOut>(list);
        List<ClientBillOutVo> billVos = new ArrayList<>();
        pageInfo.getList().forEach(bill->{
            ClientBillOutVo vo = BeanCopyUtil.copy(bill,ClientBillOutVo.class);
            TestQuotationExample quotationExample = new TestQuotationExample();
            quotationExample.createCriteria().andQuotationNumEqualTo(bill.getTradeId());
            List<TestQuotation> quotations = quotationMapper.selectByExample(quotationExample);
            if(quotations.size()!=0){
                vo.setTradeName(quotations.get(0).getTradeName());
            }
            billVos.add(vo);
        });
        return ResponseUtil.getListResponseVO(billVos,pageInfo.getTotal());
    }

    @Override
    @Transactional
    public ResponseVO addOneOutBill(BillOutAddReq req) {
        log.info("查询商户和对应的数据是否存在 id= {}", req.getId());
        ClientBillOutExample example = new ClientBillOutExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<ClientBillOut> list =outMapper.selectByExample(example);
        if( list.size() == 0) return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);

        log.info("开始核销 = {}", req);
        ClientBillOut billOut = list.get(0);
        Balance balance = balanceService.getBalance(req.getClientId());
        long amount = balance.getBalanceAmt();
        if(billOut.getUnAmt()>amount){
            return ResponseUtil.error(301,"账户资金不足");
        }
        log.info("先修改余额");
        balance.setBalanceAmt(amount-billOut.getUnAmt());
        BalanceReq balanceReq = BeanCopyUtil.copy(balance,BalanceReq.class);
        //TODO 还有其他金额？
        balanceService.updateRecord(balanceReq);

        billOut.setStatus(BillStatus.STATUS_SETTLED.getValue());
        billOut.setOperTime(new Date());
        billOut.setOperUser(String.valueOf(req.getUser().getId()));
        log.info("核销结束 billOut= {},插入一条入账信息", billOut);

        BillIncomeAddReq addReq = new BillIncomeAddReq();
        addReq.setOperType(BillStatus.BILL_OUT.getValue());
        addReq.setClientId(billOut.getClientId());
        addReq.setOperAmount(billOut.getUnAmt());
        addReq.setDescp("核销");
        addReq.setUser(req.getUser());
        incomeService.addOneIncomeBill(addReq);

        billOut.setUnAmt(0L);
        outMapper.updateByPrimaryKeySelective(billOut);

        //todo 保存佣金记录、修改客户状态为成交客户，修改最后放出日期：当前日期+30天（数字做成可配置参数）
        return ResponseUtil.success();
    }

    @Override
    @Transactional
    public boolean creditRecord(TestQuotation req){
        BalanceExample balanceExample = new BalanceExample();
        balanceExample.createCriteria().andClientIdEqualTo(req.getClientNum());
        List<Balance> list = balanceMapper.selectByExample(balanceExample);
        if(list.isEmpty()) return false;
        final Balance balance = list.get(0);
        long val = balance.getCreditLimit() - balance.getUnsettledAmt();
        if (req.getTotalCost() > val){
            return false;
        }
        //修改用户的未核销金额
        Balance update = new Balance();
        update.setId(balance.getId());
        update.setUnsettledAmt(balance.getUnsettledAmt() + req.getTotalCost());
        balanceMapper.updateByPrimaryKeySelective(update);
        //插入
        ClientBillOut row = new ClientBillOut();
        row.setClientId(req.getClientNum());
        row.setTradeId(req.getQuotationNum());
        row.setOnaccountAmt(Long.valueOf(req.getTotalCost()));
        row.setUnAmt(Long.valueOf(req.getTotalCost()));
        row.setStartTime(new Date());
        row.setStatus(BillStatus.STATUS_UNSETTLE.getValue());
        outMapper.insertSelective(row);
        return true;
    }


}
