package com.libiao.customer.controller;

import com.libiao.customer.dal.model.ClientBillIncome;
import com.libiao.customer.dal.model.ClientBillOut;
import com.libiao.customer.dal.model.CustomerBill;
import com.libiao.customer.model.ErrorMessage;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.*;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.service.BillOutService;
import com.libiao.customer.service.CustomerBillService;
import com.libiao.customer.util.AccessController;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("bill")
public class BillCtrl {

    @Autowired
    BillIncomeService incomeService;

    @Autowired
    BillOutService outService;

    @Autowired
    CustomerBillService customerBillService;

    /**
     * 获取商户入账信息列表
     **/
    @ResponseBody
    @AccessController
    @RequestMapping(value = "getAllIncomeBill", method = RequestMethod.POST)
    public ResponseEntity<ListResponseVO<ClientBillIncome>> getAllIncomeBill(@RequestBody BillIncomeReq req){
        return incomeService.getAllIncomeBill(req);
    }
    /**
     * 获取商户出账信息列表
     **/
    @ResponseBody
    @AccessController
    @RequestMapping(value = "getAllOutBill", method = RequestMethod.POST)
    public ResponseEntity<ListResponseVO<ClientBillOut>> getAllOutBill(@RequestBody BillOutReq req){
        return outService.getAllOutBill(req);
    }

    /**
     * 入账
     **/
    @ResponseBody
    @RequestMapping(value = "addOneIncomeBill", method = RequestMethod.POST)
    public ResponseVO addOneIncomeBill(@RequestBody BillIncomeAddReq req){
        req.setOperType("入账");
        return incomeService.addOneIncomeBill(req);
    }

    /**
     * 核销
     **/
    @ResponseBody
    @RequestMapping(value = "addOneOutBill", method = RequestMethod.POST)
    public ResponseVO addOneOutBill(@RequestBody BillOutAddReq req){
        return outService.addOneOutBill(req);
    }


    /**
     * 个人列表
     **/
    @ResponseBody
    @AccessController
    @RequestMapping(value = "getPersonalBillList", method = RequestMethod.POST)
    public ResponseEntity<ListResponseVO<CustomerBill>> getPersonalBillList(@RequestBody CustomerBillListReq req){
        return customerBillService.list(req);
    }

    /**
     * 详情
     **/
    @ResponseBody
    @AccessController
    @RequestMapping(value = "getPersonalBillInfo", method = RequestMethod.POST)
    public ResponseEntity getPersonalBillInfo(@RequestBody CustomerBillReq req){
        if(null == req.getId()) return ResponseUtil.convert(ErrorMessage.INVALIDATE_PARAM);
        return customerBillService.getOne(req.getId());
    }

    /**
     * 修改
     **/
    @ResponseBody
    @RequestMapping(value = "updatePersonalBill", method = RequestMethod.POST)
    public ResponseEntity updatePersonalBill(@RequestBody CustomerBillReq req){
        return customerBillService.update(req);
    }


}
