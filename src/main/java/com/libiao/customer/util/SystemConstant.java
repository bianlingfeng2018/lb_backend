package com.libiao.customer.util;

import java.io.File;
import org.apache.commons.lang3.ArrayUtils;

/**
 * @author Lingfeng
 */
public class SystemConstant {

  public static String BASE_DIR = "lb-file";
  // 检测交易附件目录
  public static String TEST_TRADE = "t";
  public static String TEST_APPLICATION_FORM = "t_af";
  public static String TEST_QUOTATION = "t_q";
  public static String TEST_WORK_ORDER = "t_wo";
  public static String TEST_REPORT = "t_r";
  public static String ATTACH_PART_1 = "1";
  public static String ATTACH_PART_2 = "2";
  // 用户附件目录
  public static String USER_DIR = "u";
  public static String SIGNATURE = "s";

  // 检测交易状态
  public static String TEST_TRADE_CREATED = "testTradeCreated";
  public static String TEST_QUOTATION_CREATED = "testQuotationCreated";
  public static String TEST_QUOTATION_CONFIRMED = "testQuotationConfirmed";
  public static String TEST_APPLICATION_CREATED = "testApplicationFormCreated";
  public static String TEST_APPLICATION_CONFIRMED = "testApplicationFormConfirmed";
  public static String TEST_WORK_ORDER_CREATED = "testWorkOrderCreated";
  public static String TEST_WORK_ORDER_CONFIRMED = "testWorkOrderConfirmed";
  public static String TEST_REPORT_CREATED = "testReportCreated";
  public static String TEST_REPORT_CONFIRMED = "testReportConfirmed";
  public static String TEST_REPORT_SECOND_CONFIRMED = "testReportSecondConfirmed";

  public static String TEST_REPORT_THIRD_CONFIRMED = "testReportThirdConfirmed";

  // 商城
  public static String MALL = "m";
  public static String GOODS = "g";

  public static String getMallGoodsImage1Dir(String goodsId) {
    return BASE_DIR + File.separator + MALL + File.separator + GOODS + File.separator + goodsId
        + File.separator + ATTACH_PART_1;
  }

  public static String getMallGoodsImage2Dir(String goodsId) {
    return BASE_DIR + File.separator + MALL + File.separator + GOODS + File.separator + goodsId
        + File.separator + ATTACH_PART_2;
  }

  public static String getTestApplicationFormPDFDir(String tradeId) {
    return BASE_DIR + File.separator + TEST_TRADE + File.separator + tradeId + File.separator
        + TEST_APPLICATION_FORM + File.separator + ATTACH_PART_1;
  }

  public static String getTestApplicationFormImageDir(String tradeId) {
    return BASE_DIR + File.separator + TEST_TRADE + File.separator + tradeId + File.separator
        + TEST_APPLICATION_FORM + File.separator + ATTACH_PART_2;
  }

  public static String getUserSignatureDir(String userId) {
    return BASE_DIR + File.separator + USER_DIR + File.separator + userId + File.separator
        + SIGNATURE;
  }

  public static String getTestReportSampleImageDir(String tradeId) {
    return BASE_DIR + File.separator + TEST_TRADE + File.separator + tradeId + File.separator
        + TEST_REPORT + File.separator + ATTACH_PART_1;
  }

  /**
   * 获取用户签名图片
   *
   * @param userId 用户id
   * @return 用户签名图片
   */
  public static File getUserSignature(String userId) {
    String dir = getUserSignatureDir(userId);
    File file = new File(dir);
    if (!file.isDirectory() || !file.exists()) {
      return null;
    }
    File[] files = file.listFiles();
    if (ArrayUtils.isEmpty(files)) {
      return null;
    }
    return files[0];
  }
}
