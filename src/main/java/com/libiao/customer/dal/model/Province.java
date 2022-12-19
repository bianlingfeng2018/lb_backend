package com.libiao.customer.dal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lingfeng
 */
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Province {

  private String provinceName;

  private String provinceCode;
  private String mergerName;
  private String pinyin;

}
