package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.ClientBillIncome;
import com.libiao.customer.model.ListResponseVO;
import com.libiao.customer.model.bill.BillIncomeAddReq;
import com.libiao.customer.model.bill.BillIncomeReq;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.http.ResponseEntity;

public interface BillIncomeService {
   ResponseEntity<ListResponseVO<ClientBillIncome>> getAllIncomeBill(BillIncomeReq req);

   ResponseVO addOneIncomeBill(BillIncomeAddReq req);

}
