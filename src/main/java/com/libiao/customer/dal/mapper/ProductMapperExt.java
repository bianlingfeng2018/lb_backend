package com.libiao.customer.dal.mapper;

import com.libiao.customer.model.product.GoodsListReq;
import com.libiao.customer.model.product.GoodsVO;

import java.util.List;

public interface ProductMapperExt {

    List<GoodsVO> getGoodsList(GoodsListReq req);

}
