package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.BalanceInfo;
import com.libiao.customer.dal.model.ClientExample;
import com.libiao.customer.dal.model.CommissionChangeRecord;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.*;
import com.libiao.customer.service.BalanceService;
import com.libiao.customer.service.CommissionService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.BeanCopyUtil;
import com.libiao.customer.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("balance")
@Api(tags = "客户账户接口")
public class BalanceController {

    @Autowired
    BalanceService balanceService;
    @Autowired
    CommissionService commissionService;



    @PostMapping("getBalanceList")
    @AccessController
    @ApiOperation("获取商户账户列表")
    public ResponseEntity<ListResponseVO<BalanceVo>> getBalanceList(@RequestBody BalanceListReq req){
        log.info("获取商户账户列表：clientID={}",req.getClient());
         PageInfo<BalanceVo> balances = balanceService.getBalanceList(req);

        return ResponseUtil.getListResponseVO(balances.getList(),balances.getTotal());
    }

    @PostMapping("getBalance")
    @AccessController
    @ApiOperation("获取单个商户账户")
    public ResponseEntity<BalanceVo> getBalance(@RequestBody BalanceReq req){
        log.info("获取商户账户信息：clientID={}",req.getClientId());
        final Balance balance = balanceService.getBalance(req.getClientId());
        log.info("查询到的商户账户信息：balance={}",balance);
        BalanceVo balanceVo = BeanCopyUtil.copy(balance,BalanceVo.class);
        return ResponseUtil.getResponseVO(balanceVo);
    }

    @PostMapping("update")
    @ApiOperation("修改商户账户")
    public ResponseEntity updateBalance(@RequestBody BalanceReq req){
        return balanceService.updateRecord(req);
    }

    @PostMapping("setCreditLimit")
    @ApiOperation("设置商户账户信用额度")
    public ResponseEntity setCreditLimit(@RequestBody CreditLimitReq req){
        Balance balance = balanceService.getBalance(req.getClientId());
        if(null == balance) return ResponseUtil.convert(HttpStatus.NOT_FOUND,"商户不存在");
        if(req.getCreditLimit()<balance.getUnsettledAmt()) return ResponseUtil.convert(HttpStatus.NOT_ACCEPTABLE,"授信额度不能小于挂账金额");

        BalanceReq balanceReq = BeanCopyUtil.copy(balance,BalanceReq.class);
        balanceReq.setCreditLimit(req.getCreditLimit());
        BalanceInfo balanceInfo = new BalanceInfo();
        balanceInfo.setClientId(req.getClientId());
        balanceInfo.setOperType("");
        balanceInfo.setDescp("设置授信额度，系统自动添加");
        balanceInfo.setOperTime(new Date());
        balanceInfo.setOperUser(String.valueOf(req.getUser().getId()));
        balanceInfo.setOperAmt(req.getCreditLimit());
        return balanceService.updateRecord(balanceReq);
    }

    @PostMapping("setCommission")
    @ApiOperation("设置商户账户佣金")
    public ResponseEntity setCommission(@RequestBody CommissionReq req){
        Balance balance = balanceService.getBalance(req.getClientId());
        if(null == balance){
            return ResponseUtil.convert(HttpStatus.NOT_FOUND,"商户记录不存在");
        }
        CommissionChangeRecord record = new CommissionChangeRecord();
        if(balance.getCommissionRate() == null){
            balance.setCommissionRate(0L);
        }
        record.setOrgRate(balance.getCommissionRate().intValue());
        balance.setCommissionRate(req.getRate().longValue());

        record.setOperUser(String.valueOf(req.getUser().getId()));
        record.setAmount(balance.getBalanceAmt());
        commissionService.addRecord(record);
        return ResponseUtil.getDefaultResp();
    }

    @PostMapping("updateCommission")
    @ApiOperation("修改商户账户佣金")
    public ResponseEntity updateCommission(@RequestBody CommissionReq req){
        return commissionService.changeRate(req);
    }

    @PostMapping("approveCommission")
    @ApiOperation("审核佣金")
    public ResponseEntity approveCommission(@RequestBody CommissionReq req){
        return commissionService.approve(req);
    }


}
