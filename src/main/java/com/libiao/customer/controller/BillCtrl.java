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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("bill")
@Api(tags = "账单接口")
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
    @ApiOperation("获取单个商户的入账列表")
    @RequestMapping(value = "getAllIncomeBill", method = RequestMethod.POST)
    public ResponseEntity<ListResponseVO<ClientBillIncome>> getAllIncomeBill(@RequestBody BillIncomeReq req){
        return incomeService.getAllIncomeBill(req);
    }
    /**
     * 获取商户出账信息列表
     **/
    @ResponseBody
    @AccessController
    @ApiOperation("获取单个商户的出账列表")
    @RequestMapping(value = "getAllOutBill", method = RequestMethod.POST)
    public ResponseEntity<ListResponseVO<ClientBillOut>> getAllOutBill(@RequestBody BillOutReq req){
        return outService.getAllOutBill(req);
    }

    /**
     * 入账
     **/
    @ResponseBody
    @ApiOperation("添加入账信息")
    @RequestMapping(value = "addOneIncomeBill", method = RequestMethod.POST)
    public ResponseVO addOneIncomeBill(@RequestBody BillIncomeAddReq req){
        req.setOperType("入账");
        return incomeService.addOneIncomeBill(req);
    }

    /**
     * 核销
     **/
    @ResponseBody
    @ApiOperation("添加核销")
    @RequestMapping(value = "addOneOutBill", method = RequestMethod.POST)
    public ResponseVO addOneOutBill(@RequestBody BillOutAddReq req){
        return outService.addOneOutBill(req);
    }


    /**
     * 个人列表
     **/
    @ResponseBody
    @AccessController
    @ApiOperation("获取个人账单信息列表")
    @RequestMapping(value = "getPersonalBillList", method = RequestMethod.POST)
    public ResponseEntity<ListResponseVO<CustomerBill>> getPersonalBillList(@RequestBody CustomerBillListReq req){
        return customerBillService.list(req);
    }

    /**
     * 详情
     **/
    @ResponseBody
    @AccessController
    @ApiOperation("获取个人客户账单信息列表详情")
    @RequestMapping(value = "getPersonalBillInfo", method = RequestMethod.POST)
    public ResponseEntity getPersonalBillInfo(@RequestBody CustomerBillReq req){
        if(null == req.getId()) return ResponseUtil.convert(ErrorMessage.INVALIDATE_PARAM);
        return customerBillService.getOne(req.getId());
    }

    /**
     * 修改
     **/
    @ResponseBody
    @ApiOperation("修改个人客户账单信息")
    @RequestMapping(value = "updatePersonalBill", method = RequestMethod.POST)
    public ResponseEntity updatePersonalBill(@RequestBody CustomerBillReq req){
        return customerBillService.update(req);
    }

    /**
     * 批量修改
     **/
    @ResponseBody
    @ApiOperation("批量修改个人客户账单信息")
    @RequestMapping(value = "updatePersonalBillBatch", method = RequestMethod.POST)
    public ResponseEntity updatePersonalBillBatch(@RequestBody CustomerBillBatchReq req){
        req.getList().forEach(customerBillReq -> {
            customerBillReq.setUser(req.getUser());
            customerBillReq.setRequestId(req.getRequestId());
            customerBillService.update(customerBillReq);
        });
        return ResponseUtil.getDefaultResp();
    }

}
