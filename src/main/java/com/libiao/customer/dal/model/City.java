package com.libiao.customer.dal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Lingfeng
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class City {

  private String cityName;

  private String cityCode;
  private String mergerName;
  private String pinyin;
}
