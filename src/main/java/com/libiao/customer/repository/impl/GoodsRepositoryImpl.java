package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.MallGoodsMapper;
import com.libiao.customer.dal.model.MallGoods;
import com.libiao.customer.repository.GoodsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class GoodsRepositoryImpl implements GoodsRepository {

  private final MallGoodsMapper goodsMapper;

  public GoodsRepositoryImpl(MallGoodsMapper goodsMapper) {
    this.goodsMapper = goodsMapper;
  }


  @Override
  public List<MallGoods> selectAll() {
    return goodsMapper.selectAll();
  }

  @Override
  public int updateById(MallGoods mallGoods) {
    return goodsMapper.updateByPrimaryKey(mallGoods);
  }

  @Override
  public int insert(MallGoods mallGoods) {
    return goodsMapper.insert(mallGoods);
  }

  @Override
  public MallGoods selectById(Long id) {
    return goodsMapper.selectByPrimaryKey(id);
  }
}
