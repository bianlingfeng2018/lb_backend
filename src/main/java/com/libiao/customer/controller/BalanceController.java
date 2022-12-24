package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.CommissionChangeRecord;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.model.balance.BalanceVo;
import com.libiao.customer.model.balance.CommissionReq;
import com.libiao.customer.model.balance.CreditLimitReq;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.CommissionService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("balance")
@Api(tags = "客户账户接口")
public class BalanceController {

    @Autowired
    BalanceService balanceService;
    @Autowired
    CommissionService commissionService;

    @PostMapping("getBalance")
    public ResponseEntity<BalanceVo> getBalance(@RequestBody BalanceReq req){
        final Balance balance = balanceService.getBalance(req.getClientId());
        BalanceVo balanceVo = BeanCopyUtil.copy(balance,BalanceVo.class);
        return ResponseUtil.getResponseVO(balanceVo);
    }

    @PostMapping("update")
    public ResponseEntity updateBalance(@RequestBody BalanceReq req){
        return balanceService.updateRecord(req);
    }

    @PostMapping("setCreditLimit")
    public ResponseEntity setCreditLimit(@RequestBody CreditLimitReq req){
        Balance balance = balanceService.getBalance(req.getClientId());
        if(null == balance) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"商户不存在");
        if(req.getCreditLimit()<balance.getUnsettledAmt()) return ResponseUtil.convert(HttpStatus.NOT_ACCEPTABLE,"授信额度不能小于挂账金额");

        BalanceReq balanceReq = BeanCopyUtil.copy(balance,BalanceReq.class);
        balanceReq.setCreditLimit(req.getCreditLimit());
        //todo:添加操作一条记录
        return balanceService.updateRecord(balanceReq);
    }

    @PostMapping("setCommission")
    public ResponseEntity setCommission(@RequestBody CommissionReq req){
        CommissionChangeRecord record = BeanCopyUtil.copy(req, CommissionChangeRecord.class);
        commissionService.addRecord(record);
        return ResponseUtil.getDefaultResp();
    }

    @PostMapping("updateCommission")
    public ResponseEntity updateCommission(@RequestBody CommissionReq req){
        return commissionService.changeRate(req);
    }

    @PostMapping("approveCommission")
    public ResponseEntity approveCommission(@RequestBody CommissionReq req){
        return commissionService.approve(req);
    }


}
