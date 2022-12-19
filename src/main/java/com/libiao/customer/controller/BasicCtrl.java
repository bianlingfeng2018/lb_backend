package com.libiao.customer.controller;

import com.libiao.customer.service.BasicService;
import com.libiao.customer.util.model.ResponseVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class BasicCtrl {

  private final BasicService basicService;

  public BasicCtrl(BasicService basicService) {
    this.basicService = basicService;
  }

  @RequestMapping(value = "/api/basic/test-item-list", method = RequestMethod.GET)
  public ResponseVO<?> getAllTestItems() {
    return basicService.getAllTestItems();
  }
  @RequestMapping(value = "/api/basic/standard-list", method = RequestMethod.GET)
  public ResponseVO<?> getAllStandards() {
    return basicService.getAllStandards();
  }
}
