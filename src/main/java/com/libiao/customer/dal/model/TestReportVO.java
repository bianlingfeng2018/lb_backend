package com.libiao.customer.dal.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Lingfeng
 */
@Getter
@Setter
public class TestReportVO extends TestReport {

  private Boolean confirmed;
  private Boolean secondConfirmed;
  private Boolean thirdConfirmed;
}
