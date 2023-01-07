package com.libiao.customer.service.impl;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.mapper.BalanceInfoMapper;
import com.libiao.customer.dal.mapper.BalanceMapper;
import com.libiao.customer.dal.mapper.ClientBillIncomeMapper;
import com.libiao.customer.dal.mapper.ClientContractMapper;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.model.balance.BalanceListReq;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.model.balance.BalanceVo;
import com.libiao.customer.model.enums.BillStatus;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceMapper balanceMapper;

    @Autowired
    BalanceInfoMapper balanceInfoMapper;

    @Autowired
    ClientContractMapper clientContractMapper;
    @Autowired
    ClientBillIncomeMapper billIncomeMapper;

    @Override
    public Balance getBalance(String clientId) {
        BalanceExample balanceExample = new BalanceExample();
        balanceExample.createCriteria().andClientIdEqualTo(clientId);
        List<Balance> list = balanceMapper.selectByExample(balanceExample);
        log.info("getBalance list={}",list);
        if(list.size() !=1){
            return null;
        }
        return list.get(0);
    }

    @Override
    public PageInfo<BalanceVo> getBalanceList(BalanceListReq listReq) {
        Map<String,String> clientIds = new HashMap<>();
        ClientContractExample clientContractExample = new ClientContractExample();
        ClientContractExample.Criteria criteria = clientContractExample.createCriteria();
        if(!StringUtils.isEmpty(listReq.getClient())){
            criteria.andClientNumEqualTo(listReq.getClient());
        }
        if(null!= listReq.getStartTime() && null!=listReq.getEndTime()){
            criteria.andContractStartDateBetween(listReq.getStartTime(),listReq.getEndTime());
        }
        List<ClientContract> clients =  clientContractMapper.selectByExample(clientContractExample);
        if(clients.size() == 0) return new PageInfo<>(new ArrayList<>());

        clients.forEach(client -> clientIds.put(client.getClientNum(),client.getClientName()));
        PageHelper.startPage(listReq.getPage(),listReq.getPageSize());
        BalanceExample balanceExample = new BalanceExample();
        balanceExample.createCriteria().andClientIdIn(new ArrayList<>(clientIds.keySet()));
        List<Balance> balances = balanceMapper.selectByExample(balanceExample);
        List<BalanceVo> vo = new ArrayList<>();
        balances.forEach(balance -> {
            BalanceVo balanceVo = BeanCopyUtil.copy(balance,BalanceVo.class);
            // 剩余收款金额=应收帐明细-收款帐-期末余额
            balanceVo.setLeftIncomeAmt(getClientIncomeCount(balance.getClientId()));
            balanceVo.setName(clientIds.get(balanceVo.getClientId()));
            vo.add(balanceVo);
        });
        return new PageInfo<>(vo);
    }

    //获取商户入账总和
    private Long getClientIncomeCount(String clientId){
        ClientBillIncomeExample billIncomeExample = new ClientBillIncomeExample();
        billIncomeExample.createCriteria().andClientIdEqualTo(clientId)
        .andOprationTypeEqualTo(BillStatus.BILL_INCOME.getValue());
        List<ClientBillIncome> billIncomes = billIncomeMapper.selectByExample(billIncomeExample);
        if(billIncomes.isEmpty()) return 0L;
         long sum = 0L;
        for (ClientBillIncome bill : billIncomes) {
            sum += (bill.getOriginAmount()-bill.getFinalAmount()-bill.getOperationAmount());
        }
        return sum;
    }


    @Override
    public boolean addRecord(BalanceReq req) {
        Balance balance = BeanCopyUtil.copy(req,Balance.class);
        int row = balanceMapper.insertSelective(balance);
        return row == 1;
    }

    @Override
    public ResponseEntity updateRecord(BalanceReq req) {
        log.info("开始查询余额记录：clientID = {},id={}",req.getClientId(),req.getId());
       Balance balance = null;
        if(null!=req.getId()){
           balance = balanceMapper.selectByPrimaryKey(req.getId());
        }else {
            BalanceExample balanceExample = new BalanceExample();
            balanceExample.createCriteria().andClientIdEqualTo(req.getClientId());
            List<Balance> list = balanceMapper.selectByExample(balanceExample);
            if(list.size() == 1){
                balance = list.get(0);
            }
        }
        if(null == balance) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录不存在");
        Balance bean = BeanCopyUtil.copy(req,Balance.class);
        bean.setId(balance.getId());
        int row = balanceMapper.updateByPrimaryKeySelective(bean);
        if(row != 1) return ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public boolean addInfo(BalanceInfo info) {
       int row = balanceInfoMapper.insertSelective(info);
        return row == 1;
    }

    @Override
    public List<BalanceInfo> getBalanceInfoList(String clientId) {
        BalanceInfoExample balanceExample = new BalanceInfoExample();
        balanceExample.createCriteria().andClientIdEqualTo(clientId);
        return  balanceInfoMapper.selectByExample(balanceExample);
    }
}
