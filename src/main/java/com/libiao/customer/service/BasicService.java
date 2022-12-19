package com.libiao.customer.service;

import com.libiao.customer.util.model.ResponseVO;

public interface BasicService {

  ResponseVO<?> getAllTestItems();

  ResponseVO<?> getAllStandards();
}
