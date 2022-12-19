package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicStandard;
import java.util.List;

public interface BasicStandardMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicStandard row);

    BasicStandard selectByPrimaryKey(Integer id);

    List<BasicStandard> selectAll();

    int updateByPrimaryKey(BasicStandard row);
}