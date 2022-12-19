package com.libiao.customer.repository;

import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicStandard;
import java.util.List;

/**
 * @author Lingfeng
 */
public interface BasicStandardRepository {

  List<BasicStandard> selectAll();

  int updateById(BasicStandard standard);

  int insert(BasicStandard standard);

  BasicStandard selectById(Integer id);
}
