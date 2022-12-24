package com.libiao.customer.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.ClientBillOutMapper;
import com.libiao.customer.dal.model.ClientBillOut;
import com.libiao.customer.dal.model.ClientBillOutExample;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.BillIncomeAddReq;
import com.libiao.customer.model.bill.BillOutAddReq;
import com.libiao.customer.model.bill.BillOutReq;
import com.libiao.customer.model.quotation.QuotationListVO;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.service.BillOutService;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class BillOutServiceImpl implements BillOutService {

    @Autowired
    ClientBillOutMapper outMapper;

    @Autowired
    BillIncomeService incomeService;


    @Override
    public ResponseEntity<ListResponseVO<ClientBillOut>> getAllOutBill(BillOutReq req) {
        PageHelper.startPage(req.getPage(), req.getPageSize());
        ClientBillOutExample example = new ClientBillOutExample();
        ClientBillOutExample.Criteria criteria = example.createCriteria();
        if (null != req.getClientId()) {
            criteria.andClientIdEqualTo(req.getClientId());
        }
        if (null != req.getStatus()) {
            criteria.andStatusEqualTo(req.getStatus());
        }
        if (null != req.getEndTime() && null != req.getStartTime()) {
            criteria.andStartTimeBetween(req.getStartTime(), req.getEndTime());
        }
        if (null != req.getLastStartTime() && null != req.getLastEndTime()) {
            criteria.andLastTimeBetween(req.getLastStartTime(), req.getLastEndTime());
        }
        List list = outMapper.selectByExample(example);
        PageInfo<ClientBillOut> pageInfo = new PageInfo<ClientBillOut>(list);
        return ResponseUtil.getListResponseVO(pageInfo.getList(),pageInfo.getTotal());
    }

    @Override
    @Transactional
    public ResponseVO addOneOutBill(BillOutAddReq req) {
        log.info("查询商户和对应的数据是否存在 id= {}", req.getId());
        ClientBillOutExample example = new ClientBillOutExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<ClientBillOut> list =outMapper.selectByExample(example);
        if( list.size() == 0) return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        if(req.getOperAmount()>0){ //TODO 这里要拿账户资金余额
            return ResponseUtil.error(301,"账户资金不足");
        }

        log.info("开始核销 = {}", req);
        ClientBillOut billOut = list.get(0);
        billOut.setStatus("已核销");
        billOut.setOperTime(new Date());
        billOut.setUnAmt(0L);
//        billOut.setOperUser(req.getOperUser());//TODO getuser
        log.info("核销结束 billOut= {},插入一条入账信息", billOut);

        BillIncomeAddReq addReq = new BillIncomeAddReq();
        addReq.setOperType("核销");
        addReq.setClientId(null);
        addReq.setOperAmount(req.getOperAmount());
        addReq.setDesc("核销");
        incomeService.addOneIncomeBill(addReq);

        //todo 保存佣金记录、修改客户状态为成交客户，修改最后放出日期：当前日期+30天（数字做成可配置参数）
        return ResponseUtil.success();
    }


}
