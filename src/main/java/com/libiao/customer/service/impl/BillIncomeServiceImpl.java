package com.libiao.customer.service.impl;

import com.libiao.customer.dal.mapper.ClientBillIncomeMapper;
import com.libiao.customer.entity.req.BillIncomeAddReq;
import com.libiao.customer.entity.req.BillIncomeReq;
import com.libiao.customer.service.BillIncomeService;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillIncomeServiceImpl implements BillIncomeService {

    @Autowired
    ClientBillIncomeMapper incomeMapper;


    @Override
    public ResponseVO<List> getAllIncomeBill(BillIncomeReq req) {
        return null;
    }

    @Override
    public ResponseVO addOneIncomeBill(BillIncomeAddReq req) {
        return null;
    }
}
