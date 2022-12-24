package com.libiao.customer.service;

import com.libiao.customer.dal.model.CommissionChangeRecord;
import com.libiao.customer.model.balance.CommissionReq;
import org.springframework.http.ResponseEntity;

public interface CommissionService {

    boolean addRecord(CommissionChangeRecord req);

    ResponseEntity changeRate(CommissionReq req);
    ResponseEntity approve(CommissionReq req);


}
