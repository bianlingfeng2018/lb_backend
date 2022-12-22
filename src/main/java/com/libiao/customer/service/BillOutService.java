package com.libiao.customer.service;

import com.libiao.customer.entity.req.BillIncomeAddReq;
import com.libiao.customer.entity.req.BillIncomeReq;
import com.libiao.customer.util.model.ResponseVO;

import java.util.List;

public interface BillOutService {
   ResponseVO<List> getAllOutBill(BillIncomeReq req);

   ResponseVO addOneOutBill(BillIncomeAddReq req);

}
