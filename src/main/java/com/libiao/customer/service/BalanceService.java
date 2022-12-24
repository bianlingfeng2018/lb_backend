package com.libiao.customer.service;

import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.BalanceInfo;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.BalanceReq;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BalanceService {

    Balance getBalance(String clientId);
    boolean addRecord(BalanceReq balance);
    ResponseEntity updateRecord(BalanceReq balance);

    boolean addInfo(BalanceInfo info);

    List<BalanceInfo> getBalanceInfoList(String clientId);

}
