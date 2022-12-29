package com.libiao.customer.service;

import com.github.pagehelper.PageInfo;
import com.libiao.customer.dal.model.BasicCountry;
import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.model.BasePageReq;
import com.libiao.customer.model.product.AddGoodsReq;
import com.libiao.customer.model.product.GoodsListReq;
import com.libiao.customer.model.product.GoodsVO;
import com.libiao.customer.model.product.StandardListReq;

import java.util.List;

public interface ProductService {
    List<BasicTestItem> getBasicTestItemList();

    List<GoodsVO> getProductList(GoodsListReq req);

    void createProduct(AddGoodsReq req);

    PageInfo<BasicCountry> countryList(BasePageReq req);

    PageInfo<BasicStandard> standardList(StandardListReq req);
}
