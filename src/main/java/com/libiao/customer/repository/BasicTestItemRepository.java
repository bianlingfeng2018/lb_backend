package com.libiao.customer.repository;

import com.libiao.customer.dal.model.BasicTestItem;
import java.util.List;

/**
 * @author Lingfeng
 */
public interface BasicTestItemRepository {

  List<BasicTestItem> selectAll();

  int updateById(BasicTestItem testItem);

  int insert(BasicTestItem testItem);

  BasicTestItem selectById(Integer id);
}
