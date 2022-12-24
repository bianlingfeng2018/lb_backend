package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.BasicStandardMapper;
import com.libiao.customer.dal.mapper.BasicTestItemMapper;
import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicStandardExample;
import com.libiao.customer.repository.BasicStandardRepository;
import com.libiao.customer.repository.BasicTestItemRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Lingfeng
 */
@Repository
public class BasicStandardRepositoryImpl implements BasicStandardRepository {

  private final BasicStandardMapper basicStandardMapper;

  public BasicStandardRepositoryImpl(BasicStandardMapper basicStandardMapper) {
    this.basicStandardMapper = basicStandardMapper;
  }

  @Override
  public List<BasicStandard> selectAll() {
    return basicStandardMapper.selectByExample(new BasicStandardExample());
  }

  @Override
  public int updateById(BasicStandard basicStandard) {
    return basicStandardMapper.updateByPrimaryKey(basicStandard);
  }

  @Override
  public int insert(BasicStandard basicStandard) {
    return basicStandardMapper.insert(basicStandard);
  }

  @Override
  public BasicStandard selectById(Integer id) {
    return basicStandardMapper.selectByPrimaryKey(id);
  }
}
