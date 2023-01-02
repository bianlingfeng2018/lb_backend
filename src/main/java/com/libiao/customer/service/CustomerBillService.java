package com.libiao.customer.service;

import com.libiao.customer.dal.model.CustomerBill;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.CustomerBillListReq;
import com.libiao.customer.model.bill.CustomerBillReq;
import com.libiao.customer.model.bill.CustomerBillVo;
import org.springframework.http.ResponseEntity;

public interface CustomerBillService {

    ResponseEntity<ListResponseVO<CustomerBillVo>> list(CustomerBillListReq req);
    ResponseEntity  getOne(Long id);
    ResponseEntity add(CustomerBillReq req);
    ResponseEntity update(CustomerBillReq req);

}
