package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.entity.req.BillOutAddReq;
import com.libiao.customer.entity.req.BillOutReq;
import com.libiao.customer.util.model.ResponseVO;

public interface BillOutService {
   ResponseVO<PageInfo> getAllOutBill(BillOutReq req);

   ResponseVO addOneOutBill(BillOutAddReq req);

}
