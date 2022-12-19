package com.libiao.customer.dal.mapper;

import com.libiao.customer.dal.model.BasicCountry;
import java.util.List;

public interface BasicCountryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BasicCountry row);

    BasicCountry selectByPrimaryKey(Integer id);

    List<BasicCountry> selectAll();

    int updateByPrimaryKey(BasicCountry row);
}