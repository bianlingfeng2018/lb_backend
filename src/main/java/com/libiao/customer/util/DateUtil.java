package com.libiao.customer.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Lingfeng
 */
public class DateUtil {

  private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
  private static final SimpleDateFormat sdfTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

  public static SimpleDateFormat getSDF() {
    return sdf;
  }
  public static SimpleDateFormat getSdfTime() {
    return sdfTime;
  }

  public static Date addDays(Date d, int days) {
    long l = d.getTime() + (long) days * 1000 * 60 * 60 * 24;
    return new Date(l);
  }

}
