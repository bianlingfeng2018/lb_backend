package com.libiao.customer.controller;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.entity.req.BillIncomeAddReq;
import com.libiao.customer.entity.req.BillIncomeReq;
import com.libiao.customer.entity.req.BillOutAddReq;
import com.libiao.customer.entity.req.BillOutReq;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.service.BillOutService;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("api/bill")
public class BillCtrl {

    @Autowired
    BillIncomeService incomeService;

    @Autowired
    BillOutService outService;

    /**
     * 获取商户入账信息列表
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllIncomeBill", method = RequestMethod.POST)
    public ResponseVO<PageInfo> getAllIncomeBill(@RequestBody BillIncomeReq req){
        return incomeService.getAllIncomeBill(req);
    }
    /**
     * 获取商户出账信息列表
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllOutBill", method = RequestMethod.POST)
    public ResponseVO<PageInfo> getAllOutBill(@RequestBody BillOutReq req){
        return outService.getAllOutBill(req);
    }

    /**
     * 入账
     **/
    @ResponseBody
    @RequestMapping(value = "/addOneIncomeBill", method = RequestMethod.POST)
    public ResponseVO addOneIncomeBill(@RequestBody BillIncomeAddReq req){
        req.setOperType("入账");
        return incomeService.addOneIncomeBill(req);
    }

    /**
     * 核销
     **/
    @ResponseBody
    @RequestMapping(value = "/addOneOutBill", method = RequestMethod.POST)
    public ResponseVO addOneOutBill(@RequestBody BillOutAddReq req){
        return outService.addOneOutBill(req);
    }
}
