package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.BalanceMapper;
import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.BalanceExample;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    BalanceMapper balanceMapper;

    @Override
    public Balance getBalance(String clientId) {
        BalanceExample balanceExample = new BalanceExample();
        balanceExample.createCriteria().andClientIdEqualTo(clientId);
        List<Balance> list = balanceMapper.selectByExample(balanceExample);
        if(list.size() !=1){
            return null;
        }
        return list.get(0);
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
}
