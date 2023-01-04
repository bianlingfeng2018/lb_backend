package com.libiao.customer.service;

import com.libiao.customer.dal.model.TestQuotation;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.BillOutAddReq;
import com.libiao.customer.model.bill.BillOutReq;
import com.libiao.customer.model.bill.ClientBillOutVo;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

public interface BillOutService {
   ResponseEntity<ListResponseVO<ClientBillOutVo>> getAllOutBill(BillOutReq req);

   ResponseVO addOneOutBill(BillOutAddReq req);

    @Transactional
    boolean creditRecord(TestQuotation req);
}
