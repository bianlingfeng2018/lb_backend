package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BalanceInfo;
import com.libiao.customer.dal.model.BalanceInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceInfoMapper {
    long countByExample(BalanceInfoExample example);

    int deleteByExample(BalanceInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(BalanceInfo row);

    int insertSelective(BalanceInfo row);

    List<BalanceInfo> selectByExample(BalanceInfoExample example);

    BalanceInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") BalanceInfo row, @Param("example") BalanceInfoExample example);

    int updateByExample(@Param("row") BalanceInfo row, @Param("example") BalanceInfoExample example);

    int updateByPrimaryKeySelective(BalanceInfo row);

    int updateByPrimaryKey(BalanceInfo row);
}