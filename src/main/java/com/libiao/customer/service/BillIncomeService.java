package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.entity.req.BillIncomeAddReq;
import com.libiao.customer.entity.req.BillIncomeReq;
import com.libiao.customer.util.model.ResponseVO;

import java.util.List;

public interface BillIncomeService {
   ResponseVO<PageInfo> getAllIncomeBill(BillIncomeReq req);

   ResponseVO addOneIncomeBill(BillIncomeAddReq req);

}
