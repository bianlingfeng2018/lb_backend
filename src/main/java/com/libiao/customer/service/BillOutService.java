package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.ClientBillOut;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.BillOutAddReq;
import com.libiao.customer.model.bill.BillOutReq;
import com.libiao.customer.model.bill.ClientBillOutVo;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.http.ResponseEntity;

public interface BillOutService {
   ResponseEntity<ListResponseVO<ClientBillOutVo>> getAllOutBill(BillOutReq req);

   ResponseVO addOneOutBill(BillOutAddReq req);

}
