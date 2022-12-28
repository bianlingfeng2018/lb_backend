package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.ClientCommission;
import com.libiao.customer.dal.model.ClientCommissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClientCommissionMapper {
    long countByExample(ClientCommissionExample example);

    int deleteByExample(ClientCommissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ClientCommission row);

    int insertSelective(ClientCommission row);

    List<ClientCommission> selectByExample(ClientCommissionExample example);

    ClientCommission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") ClientCommission row, @Param("example") ClientCommissionExample example);

    int updateByExample(@Param("row") ClientCommission row, @Param("example") ClientCommissionExample example);

    int updateByPrimaryKeySelective(ClientCommission row);

    int updateByPrimaryKey(ClientCommission row);
}