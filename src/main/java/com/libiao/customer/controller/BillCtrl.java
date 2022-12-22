package com.libiao.customer.controller;

import com.libiao.customer.dal.model.User;
import com.libiao.customer.entity.req.BillIncomeReq;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/bill")
public class BillCtrl {

    @Autowired
    BillIncomeService incomeService;


    /**
     * 获取商户入账信息
     **/
    @ResponseBody
    @RequestMapping(value = "/getAllIncomeBill", method = RequestMethod.POST)
    public ResponseVO<List> getAllIncomeBill(@RequestBody BillIncomeReq req){
        return incomeService.getAllIncomeBill(req);
    }

}
