package com.libiao.customer.repository;

import com.libiao.customer.dal.model.MallGoods;
import java.util.List;

/**
 * @author Lingfeng
 */
public interface GoodsRepository {

  List<MallGoods> selectAll();

  int updateById(MallGoods mallGoods);

  int insert(MallGoods mallGoods);

  MallGoods selectById(Long id);
}
