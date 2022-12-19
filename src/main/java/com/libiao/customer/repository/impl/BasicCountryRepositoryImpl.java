package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.BasicCountryMapper;
import com.libiao.customer.dal.mapper.BasicTestItemMapper;
import com.libiao.customer.dal.model.BasicCountry;
import com.libiao.customer.repository.BasicCountryRepository;
import com.libiao.customer.repository.BasicTestItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class BasicCountryRepositoryImpl implements BasicCountryRepository {

  private final BasicCountryMapper basicCountryMapper;

  public BasicCountryRepositoryImpl(BasicCountryMapper basicCountryMapper) {
    this.basicCountryMapper = basicCountryMapper;
  }

  @Override
  public List<BasicCountry> selectAll() {
    return basicCountryMapper.selectAll();
  }

  @Override
  public int updateById(BasicCountry basicCountry) {
    return basicCountryMapper.updateByPrimaryKey(basicCountry);
  }

  @Override
  public int insert(BasicCountry basicCountry) {
    return basicCountryMapper.insert(basicCountry);
  }

  @Override
  public BasicCountry selectById(Integer id) {
    return basicCountryMapper.selectByPrimaryKey(id);
  }
}
