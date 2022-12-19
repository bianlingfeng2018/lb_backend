package com.libiao.customer.dal.model;

import com.google.common.collect.Lists;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BasicTestItemGroupVO {

  /**
   * 可选检测项
   */
  private List<BasicTestItem> items;
  /**
   * 检测标准名称
   */
  private String name;
  /**
   * 选中的检测项id
   */
  private List<Integer> ids = Lists.newArrayList();
}