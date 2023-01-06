package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.MallGoods;
import com.libiao.customer.dal.model.MallGoodsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MallGoodsMapper {
    long countByExample(MallGoodsExample example);

    int deleteByExample(MallGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MallGoods row);

    int insertSelective(MallGoods row);

    List<MallGoods> selectByExampleWithBLOBs(MallGoodsExample example);

    List<MallGoods> selectByExample(MallGoodsExample example);

    MallGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") MallGoods row, @Param("example") MallGoodsExample example);

    int updateByExampleWithBLOBs(@Param("row") MallGoods row, @Param("example") MallGoodsExample example);

    int updateByExample(@Param("row") MallGoods row, @Param("example") MallGoodsExample example);

    int updateByPrimaryKeySelective(MallGoods row);

    int updateByPrimaryKeyWithBLOBs(MallGoods row);

    int updateByPrimaryKey(MallGoods row);
}