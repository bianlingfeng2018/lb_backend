package com.libiao.customer.repository;

import com.libiao.customer.dal.model.BasicCountry;
import com.libiao.customer.dal.model.BasicCountry;
import java.util.List;

/**
 * @author Lingfeng
 */
public interface BasicCountryRepository {

  List<BasicCountry> selectAll();

  int updateById(BasicCountry basicCountry);

  int insert(BasicCountry basicCountry);

  BasicCountry selectById(Integer id);
}
