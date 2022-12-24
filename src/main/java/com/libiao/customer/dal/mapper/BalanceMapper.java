package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Balance;
import com.libiao.customer.dal.model.BalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceMapper {
    long countByExample(BalanceExample example);

    int deleteByExample(BalanceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Balance row);

    int insertSelective(Balance row);

    List<Balance> selectByExample(BalanceExample example);

    Balance selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") Balance row, @Param("example") BalanceExample example);

    int updateByExample(@Param("row") Balance row, @Param("example") BalanceExample example);

    int updateByPrimaryKeySelective(Balance row);

    int updateByPrimaryKey(Balance row);
}