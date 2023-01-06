package com.libiao.customer.service;

import com.libiao.customer.dal.model.BasicGoodsClass;
import com.libiao.customer.dal.model.BasicGoodsMaterial;
import com.libiao.customer.dal.model.BasicHscode;
import com.libiao.customer.util.model.ResponseVO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BasicService {

  ResponseVO<?> getAllTestItems();

  ResponseVO<?> getAllStandards();

  ResponseEntity<List<BasicGoodsClass>> getAllGoodsClass();
  ResponseEntity<List<BasicGoodsMaterial>> getAllGoodsMaterial();
  ResponseEntity<List<BasicHscode>> getAllHSCode();


}
