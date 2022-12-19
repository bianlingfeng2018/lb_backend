package com.libiao.customer.controller;

import com.libiao.customer.dal.model.Finance;
import com.libiao.customer.dal.model.FinanceVO;
import com.libiao.customer.service.FinanceService;
import com.libiao.customer.util.FileVO;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class FinanceCtrl {

  private final FinanceService financeService;

  public FinanceCtrl(FinanceService financeService) {
    this.financeService = financeService;
  }

  @RequestMapping(value = "/api/finances-page", method = RequestMethod.GET)
  public ResponseVO<PageVO<FinanceVO>> getFinancesPage(
      @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
      @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
    return financeService.getFinancesByPage(pageNum, pageSize);
  }

  @RequestMapping(value = "/api/finance/{id}", method = RequestMethod.PUT)
  public ResponseVO<?> updateFinance(@PathVariable(value = "id") Long id,
      @RequestBody Finance finance) {
    return financeService.updateFinanceById(finance);
  }

  @RequestMapping(value = "/api/finance", method = RequestMethod.POST)
  public ResponseVO<?> addFinance(@RequestBody Finance finance) {
    return financeService.addFinance(finance);
  }

  @RequestMapping(value = "/api/finance/{id}", method = RequestMethod.DELETE)
  public ResponseVO<Void> deleteFinance(@PathVariable(value = "id") Long id) {
    return financeService.deleteFinanceById(id);
  }

  @RequestMapping(value = "/api/finance/{id}", method = RequestMethod.GET)
  public ResponseVO<Finance> getFinance(@PathVariable(value = "id") Long id) {
    return financeService.getFinanceById(id);
  }

  @ResponseBody
  @RequestMapping(value = "/api/test-trade-application-form-pdf", method = RequestMethod.GET)
  public ResponseVO<?> getTestTradeApplicationFormPDFs(@RequestParam("tradeId") Long tradeId){
    return financeService.getTestTradeApplicationFormPDFs(tradeId);
  }

  @ResponseBody
  @RequestMapping(value = "/api/test-trade-application-form-image", method = RequestMethod.GET)
  public ResponseVO<?> getTestTradeApplicationFormImages(@RequestParam("tradeId") Long tradeId){
    return financeService.getTestTradeApplicationFormImages(tradeId);
  }
}
