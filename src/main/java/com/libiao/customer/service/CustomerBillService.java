package com.libiao.customer.service;

import com.libiao.customer.dal.model.CustomerBill;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.CustomerBillListReq;
import com.libiao.customer.model.bill.CustomerBillReq;
import org.springframework.http.ResponseEntity;

public interface CustomerBillService {

    ResponseEntity<ListResponseVO<CustomerBill>> list(CustomerBillListReq req);
    ResponseEntity  getOne(Long id);
    ResponseEntity add(CustomerBillReq req);
    ResponseEntity update(CustomerBillReq req);

}
