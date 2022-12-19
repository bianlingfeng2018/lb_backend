package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicTestItem;
import java.util.List;

public interface BasicTestItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicTestItem row);

    BasicTestItem selectByPrimaryKey(Integer id);

    List<BasicTestItem> selectAll();

    int updateByPrimaryKey(BasicTestItem row);
}