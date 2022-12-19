package com.libiao.customer.repository.impl;

import com.libiao.customer.dal.mapper.FinanceMapper;
import com.libiao.customer.dal.model.Finance;
import com.libiao.customer.dal.model.User;
import com.libiao.customer.repository.FinanceRepository;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FinanceRepositoryImpl implements FinanceRepository {

  private final FinanceMapper financeMapper;

  public FinanceRepositoryImpl(FinanceMapper financeMapper) {
    this.financeMapper = financeMapper;
  }

  @Override
  public List<Finance> selectAll() {
    return financeMapper.selectAll();
  }

  @Override
  public int insert(Finance row) {
    return financeMapper.insert(row);
  }

  @Override
  public int updateById(Finance finance) {
    return financeMapper.updateByPrimaryKey(finance);
  }

  @Override
  public int deleteById(Long id) {
    return financeMapper.deleteByPrimaryKey(id);
  }

  @Override
  public Finance findFinanceById(Long id) {
    return financeMapper.selectByPrimaryKey(id);
  }

}
