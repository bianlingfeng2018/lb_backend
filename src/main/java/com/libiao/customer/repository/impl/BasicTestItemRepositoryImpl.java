package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.BasicTestItemMapper;
import com.libiao.customer.dal.model.BasicTestItem;
import com.libiao.customer.dal.model.BasicTestItemExample;
import com.libiao.customer.repository.BasicTestItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class BasicTestItemRepositoryImpl implements BasicTestItemRepository {

  private final BasicTestItemMapper basicTestItemMapper;

  public BasicTestItemRepositoryImpl(BasicTestItemMapper basicTestItemMapper) {
    this.basicTestItemMapper = basicTestItemMapper;
  }

  @Override
  public List<BasicTestItem> selectAll() {
    return basicTestItemMapper.selectByExample(new BasicTestItemExample());
  }

  @Override
  public int updateById(BasicTestItem basicTestItem) {
    return basicTestItemMapper.updateByPrimaryKey(basicTestItem);
  }

  @Override
  public int insert(BasicTestItem basicTestItem) {
    return basicTestItemMapper.insert(basicTestItem);
  }

  @Override
  public BasicTestItem selectById(Integer id) {
    return basicTestItemMapper.selectByPrimaryKey(id);
  }
}
