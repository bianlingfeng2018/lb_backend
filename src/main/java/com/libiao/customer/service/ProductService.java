package com.libiao.customer.service;

import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.model.product.GoodsVO;

import java.util.List;

public interface ProductService {
    List<BasicTestItem> getBasicTestItemList();

    List<GoodsVO> getProductList();
}
