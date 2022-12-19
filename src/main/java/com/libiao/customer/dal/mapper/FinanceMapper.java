package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.Finance;
import java.util.List;

public interface FinanceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Finance row);

    Finance selectByPrimaryKey(Long id);

    List<Finance> selectAll();

    int updateByPrimaryKey(Finance row);
}