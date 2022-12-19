package com.libiao.customer.util.poi;

import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

@Slf4j
public class DefaultExcelHelper implements ExcelHelper {

  private Workbook workbook;
  private int startRowIndex;

  public DefaultExcelHelper(Workbook workbook) {
    this.workbook = workbook;
    this.startRowIndex = 0;
  }

  /**
   * 按行处理
   *
   * @param handler
   */
  @Override
  public void extractExcelWorkBookByRow(ExcelRowHandler handler) {
    //get the sheet
    Sheet sheet = workbook.getSheetAt(0);
    //get the lastRowNum
    int lastRowNum = sheet.getLastRowNum();
    //i = 1, ignore the header of sheet
    for (int i = startRowIndex; i <= lastRowNum; i++) {
      Row row = sheet.getRow(i);
      handler.handleRow(row);
    }
  }
}
