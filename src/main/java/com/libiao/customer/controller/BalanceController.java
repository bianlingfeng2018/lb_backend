package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.model.balance.BalanceReq;
import com.libiao.customer.model.balance.BalanceVo;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

}
