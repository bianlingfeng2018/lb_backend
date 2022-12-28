package com.libiao.customer.service;

import com.libiao.customer.dal.model.CommissionChangeRecord;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.CommissionListReq;
import com.libiao.customer.model.balance.CommissionRecordReq;
import com.libiao.customer.model.balance.CommissionReq;
import com.libiao.customer.model.balance.CommissionVo;
import org.springframework.http.ResponseEntity;


public interface CommissionService {

    ResponseEntity<ListResponseVO<CommissionVo>> getCommissionList(CommissionListReq req);
    boolean addRecord(CommissionChangeRecord req);
    ResponseEntity updateRecord(CommissionRecordReq req);
    ResponseEntity addRate(CommissionReq req);
    ResponseEntity changeRate(CommissionReq req);
    ResponseEntity approve(CommissionReq req);

    ResponseEntity<ListResponseVO<CommissionChangeRecord>> getCommissionRecordList(CommissionListReq req);


}
