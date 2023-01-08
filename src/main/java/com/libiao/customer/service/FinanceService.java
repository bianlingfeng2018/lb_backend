package com.libiao.customer.service;

import com.libiao.customer.model.PageVO;
import com.libiao.customer.dal.model.Finance;
import com.libiao.customer.dal.model.FinanceVO;
import com.libiao.customer.util.model.ResponseVO;

public interface FinanceService {

  ResponseVO<PageVO<FinanceVO>> getFinancesByPage(int pageNo, int pageSize);

  ResponseVO<?> updateFinanceById(Finance finance);

  ResponseVO<?> addFinance(Finance finance);

  ResponseVO<Void> deleteFinanceById(Long id);

  ResponseVO<Finance> getFinanceById(Long id);

  ResponseVO<?> getTestTradeApplicationFormPDFs(Long tradeId);

  ResponseVO<?> getTestTradeApplicationFormImages(Long tradeId);
}
