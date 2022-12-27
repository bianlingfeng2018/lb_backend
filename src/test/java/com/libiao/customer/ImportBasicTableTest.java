package com.libiao.customer;

import com.libiao.customer.dal.mapper.BasicCountryMapper;
import com.libiao.customer.dal.mapper.BasicStandardMapper;
import com.libiao.customer.dal.mapper.BasicTestItemMapper;
import com.libiao.customer.dal.model.BasicCountry;
import com.libiao.customer.dal.model.BasicStandard;
import com.libiao.customer.dal.model.BasicTestItem;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import com.libiao.customer.dal.model.BasicTestItemExample;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.assertj.core.util.Lists;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Lingfeng
 */
@Slf4j
@SpringBootTest
public class ImportBasicTableTest {

  @Autowired
  BasicStandardMapper basicStandardMapper;

  @Autowired
  private BasicTestItemMapper basicTestItemMapper;

  @Autowired
  private BasicCountryMapper basicCountryMapper;

  @Test
  void testImportStandard() throws IOException {
    Set<String> standardSet = Sets.newHashSet();
    int startRowIndex = 1;
    File file = new File("基础数据整理12.6.xlsx");
    String fileName = file.getName();

    String extension = FilenameUtils.getExtension(fileName);
    Workbook wb = extension.equalsIgnoreCase("xlsx") ?
        new XSSFWorkbook(new FileInputStream(file)) :
        new HSSFWorkbook(new FileInputStream(file));

    //get the sheet
    Sheet sheet = wb.getSheetAt(5);
    //get the lastRowNum
//    int lastRowNum = sheet.getLastRowNum();
    int lastRowNum = 42;
    //i = 1, ignore the header of sheet
    for (int i = startRowIndex; i < lastRowNum; i++) {
      Row row = sheet.getRow(i);
      // 更新检测标准
      String standardName = getCellValue(row, 1);
      log.info("检测标准 {}", standardName);
      standardSet.add(standardName);
    }
    standardSet.forEach(s -> {
      BasicStandard basicStandard = new BasicStandard();
      basicStandard.setName(s);
      basicStandardMapper.insert(basicStandard);
    });
  }

  @Test
  void testImportStandardOfTestItem() throws IOException {
    List<BasicTestItem> allTestItems = basicTestItemMapper.selectByExample(new BasicTestItemExample());
    int startRowIndex = 1;
    File file = new File("基础数据整理12.6.xlsx");
    String fileName = file.getName();

    String extension = FilenameUtils.getExtension(fileName);
    Workbook wb = extension.equalsIgnoreCase("xlsx") ?
        new XSSFWorkbook(new FileInputStream(file)) :
        new HSSFWorkbook(new FileInputStream(file));

    //get the sheet
    Sheet sheet = wb.getSheetAt(5);
    //get the lastRowNum
//    int lastRowNum = sheet.getLastRowNum();
    int lastRowNum = 42;
    //i = 1, ignore the header of sheet
    for (int i = startRowIndex; i < lastRowNum; i++) {
      Row row = sheet.getRow(i);
      // 更新检测标准
      String standard = getCellValue(row, 1);
      String name = getCellValue(row, 3);
      log.info("检测标准 {}, 测试项目 {}", standard, name);
      List<BasicTestItem> testItemList = findByName(name, allTestItems);
      testItemList.forEach(item -> {
        item.setExt1(standard);
        basicTestItemMapper.updateByPrimaryKey(item);
      });
    }
  }

  private List<BasicTestItem> findByName(String testItemName, List<BasicTestItem> allTestItems) {
    return allTestItems.stream()
        .filter(testItem -> Objects.equals(testItemName.trim(), testItem.getName().trim()))
        .collect(Collectors.toList());
  }

  @Test
  void testImportTestItems() throws IOException {
    List<BasicTestItem> testItemList = Lists.newArrayList();
    int startRowIndex = 1;
    File file = new File("基础数据整理12.6.xlsx");
    String fileName = file.getName();

    String extension = FilenameUtils.getExtension(fileName);
    Workbook wb = extension.equalsIgnoreCase("xlsx") ?
        new XSSFWorkbook(new FileInputStream(file)) :
        new HSSFWorkbook(new FileInputStream(file));

    //get the sheet
    Sheet sheet = wb.getSheetAt(4);
    //get the lastRowNum
//    int lastRowNum = sheet.getLastRowNum();
    int lastRowNum = 40;
    //i = 1, ignore the header of sheet
    for (int i = startRowIndex; i < lastRowNum; i++) {
      Row row = sheet.getRow(i);
      // data
      BasicTestItem testItem = new BasicTestItem();
      testItem.setName(getCellValue(row, 1));
      testItem.setPrice(Integer.parseInt(getCellValue(row, 2)));
      testItem.setPeriod(getCellValue(row, 3));
      testItem.setQuantity(getCellValue(row, 4));
      testItem.setSubContract(getCellValue(row, 5));
      testItem.setRemark(getCellValue(row, 6));
      testItem.setComName(getCellValue(row, 7));
      testItemList.add(testItem);
    }

    for (BasicTestItem testItem : testItemList) {
      basicTestItemMapper.insert(testItem);
    }
  }

  @Test
  void testImportCounties() throws IOException {
    List<BasicCountry> basicCountryList = Lists.newArrayList();
    int startRowIndex = 1;
    File file = new File("国别（地区）代码表.xls");
    String fileName = file.getName();

    String extension = FilenameUtils.getExtension(fileName);
    Workbook wb = extension.equalsIgnoreCase("xlsx") ?
        new XSSFWorkbook(new FileInputStream(file)) :
        new HSSFWorkbook(new FileInputStream(file));

    //get the sheet
    Sheet sheet = wb.getSheetAt(0);
    //get the lastRowNum
    int lastRowNum = sheet.getLastRowNum();
//    int lastRowNum = 40;
    //i = 1, ignore the header of sheet
    for (int i = startRowIndex; i < lastRowNum; i++) {
      Row row = sheet.getRow(i);
      // data
      BasicCountry basicCountry = new BasicCountry();
      basicCountry.setCode(getCellValue(row, 0));
      basicCountry.setAbbr(getCellValue(row, 1));
      basicCountry.setName(getCellValue(row, 2));
      basicCountry.setEnName(getCellValue(row, 3));
      basicCountryList.add(basicCountry);
    }

    for (BasicCountry basicCountry : basicCountryList) {
      basicCountryMapper.insert(basicCountry);
    }
  }

  private static String getCellValue(Row row, int cellIndex) {
    Cell cell = row.getCell(cellIndex);
    String cellValue = new DataFormatter().formatCellValue(cell);
    return cellValue;
  }

}
