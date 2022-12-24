package com.libiao.customer.service;

import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.model.balance.BalanceReq;
import org.springframework.http.ResponseEntity;

public interface BalanceService {

    Balance getBalance(String clientId);
    boolean addRecord(BalanceReq balance);
    ResponseEntity updateRecord(BalanceReq balance);
}
