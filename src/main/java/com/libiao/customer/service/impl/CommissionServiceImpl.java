package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.CommissionChangeRecordMapper;
import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.CommissionChangeRecord;
import com.libiao.customer.dal.model.CommissionChangeRecordExample;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.model.balance.CommissionReq;
import com.libiao.customer.model.enums.CommissionStatus;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.CommissionService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CommissionServiceImpl implements CommissionService {

    @Autowired
    CommissionChangeRecordMapper recordMapper;

    @Autowired
    BalanceService balanceService;



    @Override
    public boolean addRecord(CommissionChangeRecord req) {
        req.setStatus(CommissionStatus.IN_APPROVE.getName());
        req.setOperTime(new Date());
//        req.setOperUser();
        return recordMapper.insertSelective(req) == 1;
    }

    @Override
    public ResponseEntity changeRate(CommissionReq req) {
        if(null == req.getId())return ResponseUtil.convert(HttpStatus.NOT_ACCEPTABLE,"id必传");
        CommissionChangeRecordExample example = new CommissionChangeRecordExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<CommissionChangeRecord> list = recordMapper.selectByExample(example);
        if(list.size()!=1) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录未找到");
        CommissionChangeRecord record = list.get(0);
        record.setStatus(CommissionStatus.IN_APPROVE.getName());
        record.setRate(record.getRate());
//        record.setOperUser();
        record.setOperTime(new Date());
        int row = recordMapper.updateByPrimaryKey(record);
        if(row != 1) return  ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");
        return ResponseUtil.getDefaultResp();
    }

    @Override
    public ResponseEntity approve(CommissionReq req) {
        if(null == req.getId())return ResponseUtil.convert(HttpStatus.NOT_ACCEPTABLE,"id必传");
        CommissionChangeRecordExample example = new CommissionChangeRecordExample();
        example.createCriteria().andIdEqualTo(req.getId()).andClientIdEqualTo(req.getClientId());
        List<CommissionChangeRecord> list = recordMapper.selectByExample(example);
        if(list.size()!=1) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"记录未找到");
        CommissionChangeRecord record = list.get(0);
        record.setStatus(CommissionStatus.valueOf(req.getStatus()).getName());
        record.setDesc(req.getDesc());
        record.setRate(req.getRate());
        //        record.setOperUser();
        record.setOperTime(new Date());
        int row = recordMapper.updateByPrimaryKey(record);
        if(row != 1) return  ResponseUtil.convert(HttpStatus.INTERNAL_SERVER_ERROR,"系统错误");

        Balance balance = balanceService.getBalance(req.getClientId());
        if(null == balance) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"商户不存在");
        BalanceReq balanceReq = BeanCopyUtil.copy(balance,BalanceReq.class);
        balanceReq.setCommissionRate(Long.valueOf(req.getRate()));
        return balanceService.updateRecord(balanceReq);
    }
}
