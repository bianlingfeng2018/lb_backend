package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.BalanceInfo;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.balance.BalanceListReq;
import com.libiao.customer.model.balance.BalanceReq;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BalanceService {

    Balance getBalance(String clientId);
    PageInfo<Balance> getBalanceList(BalanceListReq listReq);
    boolean addRecord(BalanceReq balance);
    ResponseEntity updateRecord(BalanceReq balance);

    boolean addInfo(BalanceInfo info);

    List<BalanceInfo> getBalanceInfoList(String clientId);

}
