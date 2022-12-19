package com.libiao.customer.repository;

import com.libiao.customer.dal.model.Finance;
import java.util.List;

public interface FinanceRepository {

  List<Finance> selectAll();

  int insert(Finance row);

  int updateById(Finance finance);

  int deleteById(Long id);

  Finance findFinanceById(Long id);
}
