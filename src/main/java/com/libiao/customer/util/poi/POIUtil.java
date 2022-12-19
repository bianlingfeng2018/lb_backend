package com.libiao.customer.util.poi;

import com.libiao.customer.dal.model.Client;
import java.util.List;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Lingfeng
 */
public class POIUtil {

  public static int COL_WIDTH = 6000;

  private static String[] colDescArr = {"客户编号", "客户中文名称", "客户简称", "行业分类",
      "客户来源", "客户分类", "客户状态", "商机数", "未完结报价单", "上次成交日期", "最后跟进人",
      "最后跟进日期", "剩余保护天数"};

  public static XSSFWorkbook buildWorkbook(List<Client> clients) {
    XSSFWorkbook workbook = new XSSFWorkbook();
    CellStyle cellStyle = getColumnStyle(workbook);
    CellStyle contentStyle = getContentStyle(workbook);
    XSSFSheet sheet = workbook.createSheet();
    XSSFRow firstRow = sheet.createRow(0);
    for (int i = 0; i < colDescArr.length; i++) {
      sheet.setColumnWidth(i, COL_WIDTH);
      XSSFCell cell = firstRow.createCell(i, CellType.STRING);
      cell.setCellStyle(cellStyle);
      cell.setCellValue(colDescArr[i]);
    }
    for (int i = 0; i < clients.size(); i++) {
      XSSFRow row = sheet.createRow(i + 1);
      Client client = clients.get(i);
      createCell(row, 0, contentStyle, client.getClientNum());
      createCell(row, 1, contentStyle, client.getName());
      createCell(row, 2, contentStyle, client.getAbbr());
      createCell(row, 3, contentStyle, client.getIndustClass());
      createCell(row, 4, contentStyle, client.getSource());
      createCell(row, 5, contentStyle, client.getClientClass());
      createCell(row, 6, contentStyle, client.getStatus());
      createCell(row, 7, contentStyle, client.getOppNumb());
      createCell(row, 8, contentStyle, client.getNotCompQuot());
      createCell(row, 9, contentStyle, client.getLastFinishDate());
      createCell(row, 10, contentStyle, client.getLastTraceUser());
      createCell(row, 11, contentStyle, client.getInvoiceName());
      createCell(row, 12, contentStyle, client.getReserveDays());
    }
    return workbook;
  }

  private static void createCell(XSSFRow row, int i, CellStyle contentStyle, String client) {
    XSSFCell cell = row.createCell(i, CellType.STRING);
    cell.setCellStyle(contentStyle);
    cell.setCellValue(client);
  }

  private static CellStyle getColumnStyle(XSSFWorkbook workbook) {
    XSSFFont font = workbook.createFont();
    font.setFontName("Calibri");
    font.setFontHeight(11);
    font.setBold(true);
    CellStyle style = workbook.createCellStyle();
    style.setFont(font);
//		style.setFillForegroundColor(IndexedColors.YELLOW.index);
//		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    return style;
  }

  /**
   * @return
   */
  private static CellStyle getContentStyle(XSSFWorkbook workbook) {
    XSSFFont font = workbook.createFont();
    font.setFontName("SimSun");
    font.setFontHeight(11);
    CellStyle style = workbook.createCellStyle();
    style.setFont(font);
    style.setBorderRight(BorderStyle.THIN);
    style.setBorderBottom(BorderStyle.THIN);
    style.setBorderLeft(BorderStyle.THIN);
    return style;
  }

}
