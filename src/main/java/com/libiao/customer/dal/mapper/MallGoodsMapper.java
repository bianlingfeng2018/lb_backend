package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.MallGoods;
import java.util.List;

public interface MallGoodsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MallGoods row);

    MallGoods selectByPrimaryKey(Long id);

    List<MallGoods> selectAll();

    int updateByPrimaryKey(MallGoods row);
}