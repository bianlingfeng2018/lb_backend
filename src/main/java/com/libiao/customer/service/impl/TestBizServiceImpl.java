package com.libiao.customer.service.impl;

import static com.libiao.customer.util.SystemConstant.TEST_APPLICATION_CREATED;
import static com.libiao.customer.util.SystemConstant.TEST_REPORT_CONFIRMED;
import static com.libiao.customer.util.SystemConstant.TEST_REPORT_SECOND_CONFIRMED;
import static com.libiao.customer.util.SystemConstant.TEST_REPORT_THIRD_CONFIRMED;
import static com.libiao.customer.util.SystemConstant.TEST_WORK_ORDER_CREATED;
import static com.libiao.customer.util.SystemConstant.getTestApplicationFormImageDir;
import static com.libiao.customer.util.SystemConstant.getTestApplicationFormPDFDir;
import static com.libiao.customer.util.SystemConstant.getTestReportSampleImageDir;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_AUDIT_1;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_AUDIT_2;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_AUDIT_3;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_CLIENT;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_SALESMAN;
import static com.libiao.customer.util.UserRolePermissionConstUtil.ROLE_TEST;
import static com.libiao.customer.util.UserRolePermissionUtil.isAdmin;
import static com.libiao.customer.util.file.FileUploadUtil.recurseDelFile;
import static com.libiao.customer.util.file.FileUploadUtil.uploadToFileDir;

import com.alibaba.druid.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.common.collect.Lists;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.repository.FinanceRepository;
import com.libiao.customer.repository.TestRespository;
import com.libiao.customer.repository.UserRepository;
import com.libiao.customer.repository.UserTestTradeRepository;
import com.libiao.customer.service.TestBizService;
import com.libiao.customer.util.ConvertUtil;
import com.libiao.customer.util.FileVO;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import com.libiao.customer.util.exception.LibiaoException;
import com.libiao.customer.util.file.FileUtil;
import com.libiao.customer.util.model.ResponseVO;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;


@Service
public class TestBizServiceImpl implements TestBizService {

    @Autowired
    private TestRespository testRespository;

    @Autowired
    private UserTestTradeRepository userTestTradeRepository;

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseVO saveTestTrade(TestTrade testTrade) {
        try{
            if(StringUtils.isEmpty(testTrade.getStatus())){
                testTrade.setStatus("testTradeCreated");
            }

            testRespository.insertTestTrade(testTrade);

            // 更新用户访问权限
            userTestTradeRepository.insert(testTrade.getClientId(), testTrade.getId());
            userTestTradeRepository.insert(testTrade.getOwnerId(), testTrade.getId());

            JSONObject saveResult = new JSONObject();
            saveResult.put("id", testTrade.getId());
            saveResult.put("msg", "检测交易创建完成");
            return ResponseUtil.success(saveResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO updateTestTrade(TestTrade testTrade) {
        try{
            if (testTrade.getId() == null){
                return ResponseUtil.error(412, "上传的参数缺少id");
            }
            TestTrade oldTestTrade = testRespository.selectTestTradeById(testTrade.getId());
            if(oldTestTrade == null){
                return ResponseUtil.error(404, "相关检测交易没有找到，检测交易更新失败.");
            }
            testTrade.setGmtCreate(oldTestTrade.getGmtCreate());
            Date now = new Date();
            testTrade.setGmtModify(now); // 更新更改的时间
            testRespository.updateTestTradeByPrimaryKey(testTrade);

            // 更新用户访问权限
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTrade.getId(), ROLE_CLIENT);
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTrade.getId(), ROLE_SALESMAN);
            userTestTradeRepository.insert(testTrade.getClientId(), testTrade.getId());
            userTestTradeRepository.insert(testTrade.getOwnerId(), testTrade.getId());

            JSONObject updateResult = new JSONObject();
            updateResult.put("id", testTrade.getId());
            updateResult.put("msg", "检测交易更新成功");
            return ResponseUtil.success(updateResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO updateTestTradeStatus(Long testTradeId, String status) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易没有找到，检测交易更新失败.");
            }
            String statusOld = testTrade.getStatus();
            testTrade.setStatus(status);
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            JSONObject result = new JSONObject();
            result.put("oldStatus", statusOld);
            result.put("curStatus", status);
            result.put("msg", "状态更新成功");
            return ResponseUtil.success(result);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO deleteTestTrade(Long testTradeId) {
        try{
            int affected_rows = testRespository.deleteTestTradeById(testTradeId);
            JSONObject delResult = new JSONObject(true);
            delResult.put("delStatus", true);
            delResult.put("affected_rows", affected_rows);
            delResult.put("msg", "删除检测交易成功.");
            return ResponseUtil.success(delResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO queryTestTradeList(int pageNum, int pageSize, String testName, String client, String status) {
        try{
            String userName = WebUtil.getAccessToken().getUsername();
            String permission = WebUtil.getAccessToken().getPermission();
            List<TestTrade> testTradeList = null;
            PageHelper.startPage(pageNum, pageSize);
            PageHelper.orderBy("id desc");
            if(isAdmin(permission)){
                testTradeList = testRespository.selectAllTestTrade();
            }else{
                testTradeList = testRespository.selectAllTestTradeByOwner(userName);
            }
            if(!StringUtils.isEmpty(testName)){
                testTradeList = testTradeList.stream().filter(item -> item.getTestName().contains(testName)).collect(Collectors.toList());
            }
            if(!StringUtils.isEmpty(client)){
                testTradeList = testTradeList.stream().filter(item -> item.getClient().contains(client)).collect(Collectors.toList());
            }
            if(!StringUtils.isEmpty(status)){
                testTradeList = testTradeList.stream().filter(item -> item.getStatus().contains(status)).collect(Collectors.toList());
            }
            PageInfo<TestTrade> pageInfo = new PageInfo<>(testTradeList);
            return ResponseUtil.success(pageInfo);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    /**
     *
     * @param testQuotation
     * @return
     */
    /*@Override
    public ResponseVO  saveTestQuotation(TestQuotation testQuotation) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testQuotation.getTestTradeId());
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            testTrade.setStatus("testQuotationCreated"); // 更新状态, 检测报价单创建完成
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            testRespository.insertTestQuotation(testQuotation);
            // 更新用户访问权限
            userTestTradeRepository.insert(testQuotation.getServiceId(), testTrade.getId());
            JSONObject saveResult = new JSONObject();
            saveResult.put("testQuotationId", testQuotation.getId());
            saveResult.put("msg", "报价表写入数据库成功");
            return ResponseUtil.success(saveResult);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    /**
     * 更新报价单
     * @param testQuotation
     * @return
     */
    /*@Override
    public ResponseVO updateTestQuotation(TestQuotation testQuotation) {
        try {
            if (testQuotation.getId() == null) {
                return ResponseUtil.error(412, "上传的参数缺少id");
            }
            Long testTradeId = testQuotation.getTestTradeId();
            TestQuotation oldTestQuotation = testRespository.queryTestQuotationByTestTradeId(
                testTradeId);
            if (oldTestQuotation == null) {
                return ResponseUtil.error(404, "相关检测报价单没有找到，更新失败");
            }
            testRespository.updateTestQuotationByPrimaryKey(testQuotation);
            List<TestQuotationItem> oldList = oldTestQuotation.getTestQuotationItemList();
            if (!CollectionUtils.isEmpty(oldList)) {
                for (TestQuotationItem testQuotationItem : oldList) {
                    testRespository.deleteTestQuotationItemById(testQuotationItem.getId());
                }
            }
            List<TestQuotationItem> newList = testQuotation.getTestQuotationItemList();
            if (!CollectionUtils.isEmpty(newList)) {
                for (TestQuotationItem testQuotationItem : newList) {
                    testQuotationItem.setId(null);
                    testQuotationItem.setTestQuotationId(testQuotation.getId());
                    testRespository.insertTestQuotationItem(testQuotationItem);
                }
            }

            // 更新用户访问权限
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTradeId,
                ROLE_CUSTOM_SERVICE);
            userTestTradeRepository.insert(testQuotation.getServiceId(), testTradeId);

            JSONObject updateResult = new JSONObject();
            updateResult.put("id", testTradeId);
            updateResult.put("msg", "检测交易更新成功");
            return ResponseUtil.success(updateResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

  /**
   * 查询报价单
   *
   * @param pageNum
   * @param pageSize
   * @return
   */
  /*@Override
  public ResponseVO queryTestQuotationList(int pageNum, int pageSize) {
    try {
      List<TestQuotation> testQuotationList = testRespository.queryTestQuotation(pageNum, pageSize);
      for (TestQuotation testQuotation : testQuotationList) {
        List<TestQuotationItem> testQuotationItemList = testRespository.queryTestQuotationItemByQuotationId(
            testQuotation.getId());
        testQuotation.setTestQuotationItemList(testQuotationItemList);
      }
      PageInfo<TestQuotation> pageInfo = new PageInfo<>(testQuotationList);
      // DO转VO，并加入交易状态信息
      PageInfo<TestQuotationVO> voPageInfo = ConvertUtil.DO2VO(pageInfo, entity -> {
        TestQuotationVO vo = new TestQuotationVO();
        BeanUtils.copyProperties(entity, vo);
        Long testTradeId = entity.getTestTradeId();
        TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
        if (Objects.nonNull(testTrade)) {
          String status = testTrade.getStatus();
          vo.setConfirmed(!Objects.equals(status, TEST_QUOTATION_CREATED));
        } else {
          vo.setConfirmed(false);
        }
        return vo;
      });
      return ResponseUtil.success(voPageInfo);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }*/

    /**
     * @param response
     * @param testTradeId
     * @return
     */
    //@Override
    /*public ResponseVO exportTestQuotation(HttpServletResponse response, Long testTradeId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId); // 查找检测交易单
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            TestQuotation testQuotation = testRespository.queryTestQuotationByTestTradeId(testTradeId);
            if(testQuotation == null){
                return ResponseUtil.error(404, "相关报价单不存在");
            }
            File file = FileUtil.exportTestQuotation(testQuotation, String.valueOf(testTradeId) + "_报价单.pdf");
            if(file.exists()){
                FileInputStream inputStream = new FileInputStream(file);
                response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode("报价单", "UTF-8"));
                response.setContentType( "application/x-msdownload");
                ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                JSONObject downloadResult = new JSONObject(true);
                downloadResult.put("fileName", "报价单");
                downloadResult.put("msg", "下载成功");
                return ResponseUtil.success(downloadResult);
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

  /**
   * 保存申请单
   *
   * @param testApplicationForm
   * @return
   */
  /*@Override
  public ResponseVO saveTestApplicationForm(TestApplicationForm testApplicationForm) {
    try {
      TestTrade testTrade = testRespository.selectTestTradeById(
          testApplicationForm.getTestTradeId());
      if (testTrade == null) {
        return ResponseUtil.error(404, "相关检测交易不存在");
      }
      testTrade.setStatus("testApplicationFormCreated"); // 更新状态, 检测申请单为创建完成
      testRespository.updateTestTradeByPrimaryKey(testTrade);
      testRespository.insertTestApplicationForm(testApplicationForm);
      JSONObject saveResult = new JSONObject();
      saveResult.put("testApplicationFormId", testApplicationForm.getId());
      saveResult.put("msg", "申请表写入数据库成功");
      return ResponseUtil.success(saveResult);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }

  }*/

    /**
     * 查询申请单
     * @param pageNum
     * @param pageSize
     * @return
     */
    /*@Override
    public ResponseVO queryTestApplicationFormList(int pageNum, int pageSize) {
      try {
        List<TestApplicationForm> testApplicationFormList = testRespository.queryTestApplicationForm(
            pageNum, pageSize);
        for (TestApplicationForm testApplicationForm : testApplicationFormList) {
          List<TestApplicationItem> testApplicationItemList = testRespository.queryTestApplicationItemByApplicationFormId(
              testApplicationForm.getId());
          testApplicationForm.setTestApplicationItemList(testApplicationItemList);
        }
        PageInfo<TestApplicationForm> pageInfo = new PageInfo<>(testApplicationFormList);
        // DO转VO，并加入交易状态信息
        PageInfo<TestApplicationFormVO> voPageInfo = ConvertUtil.DO2VO(pageInfo, entity -> {
          TestApplicationFormVO vo = new TestApplicationFormVO();
          BeanUtils.copyProperties(entity, vo);
          Long testTradeId = entity.getTestTradeId();
          TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
          if (Objects.nonNull(testTrade)) {
            String status = testTrade.getStatus();
            vo.setConfirmed(!Objects.equals(status, TEST_APPLICATION_CREATED));
          } else {
            vo.setConfirmed(false);
          }
          return vo;
        });
        return ResponseUtil.success(voPageInfo);
      } catch (Exception e) {
        e.printStackTrace();
        return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
      }
    }*/

    /**
     * 导出申请表
     * @param response
     * @param testTradeId：检测交易id
     * @return
     */
    /*@Override
    public ResponseVO exportTestApplicationForm(HttpServletResponse response, Long testTradeId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId); // 查找检测交易单
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            TestApplicationForm testApplicationForm = testRespository.queryTestApplicationFormByTestTradeId(testTradeId);
            if(testApplicationForm == null){
                return ResponseUtil.error(404, "相关申请单不存在");
            }
            String outPath = String.valueOf(testTradeId) + "_申请单.pdf"; // 申请单路径
            File file = FileUtil.exportTestApplicationForm(testApplicationForm, outPath);
            if(file.exists()){
                FileInputStream inputStream = new FileInputStream(file);
                response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode("申请单", "UTF-8"));
                response.setContentType( "application/x-msdownload");
                ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                JSONObject downloadResult = new JSONObject(true);
                downloadResult.put("fileName", String.valueOf(testTradeId) + "_申请单");
                downloadResult.put("msg", "下载成功");
                return ResponseUtil.success(downloadResult);
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    /**
     *
     * @param testWorkOrder
     * @return
     */
    /*@Override
    public ResponseVO saveTestWorkOrder(TestWorkOrder testWorkOrder) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testWorkOrder.getTestTradeId());
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            testTrade.setStatus("testWorkOrderCreated"); // 更新状态，检测工作单创建完成
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            testRespository.insertTestWorkOrder(testWorkOrder);

            // 更新用户访问权限
            userTestTradeRepository.insert(testWorkOrder.getTestId(), testTrade.getId());
            userTestTradeRepository.insert(testWorkOrder.getEditorId(), testTrade.getId());
            userTestTradeRepository.insert(testWorkOrder.getReviewerId(), testTrade.getId());
            userTestTradeRepository.insert(testWorkOrder.getApproverId(), testTrade.getId());

            JSONObject saveResult = new JSONObject();
            saveResult.put("testWorkOrderId", testWorkOrder.getId());
            saveResult.put("msg", "工作单写入数据库成功");
            return ResponseUtil.success(saveResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

  /**
   * 查询工作单
   * @param pageNum
   * @param pageSize
   * @return
   */
  /*@Override
  public ResponseVO queryTestWorkOrderList(int pageNum, int pageSize) {
    try {
      List<TestWorkOrder> testWorkOrderList = testRespository.queryTestWorkOrder(pageNum, pageSize);
      for (TestWorkOrder testWorkOrder : testWorkOrderList) {
        List<TestWorkOrderItem> testWorkOrderItemList = testRespository.queryTestWorkOrderItemByWorkOrderId(
            testWorkOrder.getId());
        testWorkOrder.setTestWorkOrderItemList(testWorkOrderItemList);
      }
      PageInfo<TestWorkOrder> pageInfo = new PageInfo<>(testWorkOrderList);
      // DO转VO，并加入交易状态信息
      PageInfo<TestWorkOrderVO> voPageInfo = ConvertUtil.DO2VO(pageInfo, entity -> {
        TestWorkOrderVO vo = new TestWorkOrderVO();
        BeanUtils.copyProperties(entity, vo);
        Long testTradeId = entity.getTestTradeId();
        TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
        if (Objects.nonNull(testTrade)) {
          String status = testTrade.getStatus();
          vo.setConfirmed(!Objects.equals(status, TEST_WORK_ORDER_CREATED));
        } else {
          vo.setConfirmed(false);
        }
        return vo;
      });
      return ResponseUtil.success(voPageInfo);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }*/

    /**
     * 导出工作单
     * @param testTradeId
     * @return
     */
    /*@Override
    public ResponseVO exportTestWorkOrder(HttpServletResponse response, Long testTradeId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId); // 查找检测交易单
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            TestWorkOrder testWorkOrder = testRespository.queryTestWorkOrderByTestTradeId(testTradeId);
            if(testWorkOrder == null){
                return ResponseUtil.error(404, "相关工作单不存在");
            }
            String outPath = String.valueOf(testTradeId) + "_工作单.pdf"; // 申请单路径
            File file = FileUtil.exportTestWorkOrder(testWorkOrder, outPath);
            if(file.exists()){
                FileInputStream inputStream = new FileInputStream(file);
                response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode("工作单", "UTF-8"));
                response.setContentType( "application/x-msdownload");
                ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                JSONObject downloadResult = new JSONObject(true);
                downloadResult.put("fileName", String.valueOf(testTradeId) + "_工作单");
                downloadResult.put("msg", "下载成功");
                return ResponseUtil.success(downloadResult);
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    @Override
    public ResponseVO queryTestQuotationByTestTradeId(Long testTradeId) {
        return null;
    }

    @Override
    public ResponseVO queryTestApplicationFormByTestTradeId(Long testTradeId) {
        return null;
    }

    @Override
    public ResponseVO queryTestWorkOrderByTestTradeId(Long testTradeId) {
        return null;
    }

    /*@Override
    public ResponseVO queryAllFormByTestTradeId(Long testTradeId) {
        try{
            JSONObject allFormsResult = new JSONObject();
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            allFormsResult.put("testTrade", (JSONObject)JSONObject.toJSON(testTrade));
            TestQuotation testQuotation = testRespository.queryTestQuotationByTestTradeId(testTradeId);
            TestApplicationForm testApplicationForm = testRespository.queryTestApplicationFormByTestTradeId(testTradeId);
            TestWorkOrder testWorkOrder = testRespository.queryTestWorkOrderByTestTradeId(testTradeId);
            TestReport testReport = testRespository.queryTestReportByTestTradeId(testTradeId);
            if(testQuotation != null){
                allFormsResult.put("testQuotation", (JSONObject)JSONObject.toJSON(testQuotation));
            }
            if(testApplicationForm != null){
                JSONObject testApplicationFormResult = (JSONObject) JSONObject.toJSON(testApplicationForm);
                testApplicationFormResult.put("flexObj", JSONObject.parse(testApplicationForm.getFlexObj()));
                allFormsResult.put("testApplicationForm", testApplicationFormResult);
            }
            if(testWorkOrder != null){
                JSONObject testWorkOrderResult = (JSONObject) JSONObject.toJSON(testWorkOrder);
                testWorkOrderResult.put("flexObj", JSONObject.parse(testWorkOrder.getFlexObj()));
                allFormsResult.put("testWorkOrder", testWorkOrderResult);
            }
            if(testReport != null){
                JSONObject testReportResult = (JSONObject) JSONObject.toJSON(testReport);
                testReportResult.put("sampleDesc", JSONObject.parse(testReport.getSampleDesc()));
                testReportResult.put("testExperiment", JSONObject.parse(testReport.getTestExperiment()));
                testReportResult.put("testRemark", JSONObject.parse(testReport.getTestRemark()));
                testReportResult.put("flexObj", JSONObject.parse(testReport.getFlexObj()));
                allFormsResult.put("testReport", testReportResult);
            }
            return ResponseUtil.success(allFormsResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    @Override
    public ResponseVO saveTestReport(String testReportStr, MultipartFile[] imgList) {
        try {
            TestReport testReport = JSON.parseObject(testReportStr, TestReport.class);
            TestTrade testTrade = testRespository.selectTestTradeById(Long.valueOf(testReport.getTestTradeId()));
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            TestReport oldTestReport = testRespository.selectTestReportByReportNum(testReport.getReportNum());
            if (Objects.nonNull(oldTestReport)) {
                return ResponseUtil.error(404, "报告编号已存在");
            }
            //上传附件
            String dir1 = getTestReportSampleImageDir(String.valueOf(testTrade.getId()));
            recurseDelFile(dir1);
            uploadToFileDir(dir1, imgList);

            testTrade.setStatus("testReportCreated"); // 更新状态，检测报告单创建完成
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            testRespository.insertTestReport(testReport);
            JSONObject saveResult = new JSONObject();
            saveResult.put("testReportId", testReport.getId());
            saveResult.put("msg", "报告单写入数据库成功");
            return ResponseUtil.success(saveResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    /**
     * 查询报告单列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public ResponseVO<?> queryTestReportList(int pageNum, int pageSize) {
      try {
        List<TestReport> testReportList = testRespository.queryTestReport(pageNum, pageSize);
        PageInfo<TestReport> pageInfo = new PageInfo<>(testReportList);
        // DO转VO，并加入交易状态信息
        PageInfo<TestReportVO> voPageInfo = ConvertUtil.DO2VO(pageInfo, entity -> {
          TestReportVO vo = new TestReportVO();
          BeanUtils.copyProperties(entity, vo);
          Long testTradeId = Long.valueOf(entity.getTestTradeId());
          TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
          if (Objects.nonNull(testTrade)) {
            String status = testTrade.getStatus();
            if (Objects.equals(status, TEST_REPORT_CONFIRMED)) {
              vo.setConfirmed(true);
            } else if (Objects.equals(status, TEST_REPORT_SECOND_CONFIRMED)) {
              vo.setSecondConfirmed(true);
            }  else if (Objects.equals(status, TEST_REPORT_THIRD_CONFIRMED)) {
              vo.setThirdConfirmed(true);
            } else {
              vo.setConfirmed(false);
              vo.setSecondConfirmed(false);
              vo.setThirdConfirmed(false);
            }
          } else {
            vo.setConfirmed(false);
            vo.setSecondConfirmed(false);
          }
          return vo;
        });
        return ResponseUtil.success(voPageInfo);
      } catch (Exception e) {
        return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
      }
    }

    /**
     *
     * @param serviceStaffId
     * @param testTradeId
     * @param customerId
     * @return
     */
    @Override
    public ResponseVO confirmTestQuotation(Long serviceStaffId, Long testTradeId, Long customerId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            testTrade.setGmtModify(new Date());
            testTrade.setStatus("testQuotationConfirmed"); // 修改状态
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            // 将报价单发送给客服.
            JSONObject confirmTestQuotationResult = new JSONObject(true);
            confirmTestQuotationResult.put("testTradeId", testTradeId);
            confirmTestQuotationResult.put("serviceStaffId", serviceStaffId);
            confirmTestQuotationResult.put("customerId", customerId);
            confirmTestQuotationResult.put("msg", "报价单确认完成.");
            return ResponseUtil.success(confirmTestQuotationResult);
        }catch (Exception e){
           return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO uploadTestApplicationForm(MultipartFile file, Long testTradeId) {
        try{
            if(file.isEmpty()){
                return ResponseUtil.error(ErrorCodeEnum.UPLOAD_ERROR_NO_FILE); // 没有文件被上传
            }
            String fileName = file.getOriginalFilename();
            // 上传文件操作
            JSONObject uploadFileResult = new JSONObject();
            uploadFileResult.put("testTradeId", testTradeId);
            uploadFileResult.put("fileName", fileName);
            uploadFileResult.put("msg", "申请表保存成功");
            return ResponseUtil.success(uploadFileResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO confirmTestApplicationFormPayment(Long testTradeId, Long financialStaffId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            testTrade.setGmtModify(new Date());
            testTrade.setStatus("testApplicationFormConfirmed"); // 修改状态
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            // 发送消息给财务
            JSONObject confirmTestApplicationFormResult = new JSONObject(true);
            confirmTestApplicationFormResult.put("testTradeId", testTradeId);
            confirmTestApplicationFormResult.put("financialStaffId", financialStaffId);
            confirmTestApplicationFormResult.put("msg", "申请单确认完成");
            return ResponseUtil.success(confirmTestApplicationFormResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO confirmTestWorkOrder(Long testTradeId, Long testingStaffId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            testTrade.setGmtModify(new Date());
            testTrade.setStatus("testWorkOrderConfirmed"); // 修改状态
            testRespository.updateTestTradeByPrimaryKey(testTrade);
            JSONObject confirmTestWorkOrderResult = new JSONObject(true);
            confirmTestWorkOrderResult.put("testTradeId", testTradeId);
            confirmTestWorkOrderResult.put("testingStaffId", testingStaffId);
            confirmTestWorkOrderResult.put("msg", "工作单确认成功");
            return ResponseUtil.success(confirmTestWorkOrderResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO confirmTestReport(Long testTradeId, List<UserExt> userExtList) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            testTrade.setGmtModify(new Date());
            testTrade.setStatus("testReportConfirmed"); // 修改状态
            testRespository.updateTestTradeByPrimaryKey(testTrade);

            JSONObject confirmTestReportResult = new JSONObject();
            confirmTestReportResult.put("testTradeId", testTradeId);
            confirmTestReportResult.put("msg", "报告单确认完成");
            return ResponseUtil.success(confirmTestReportResult);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO exportTestReport(HttpServletResponse response, Long testTradeId) {
        try{
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if(testTrade == null){
                return ResponseUtil.error(404, "相关检测交易不存在");
            }
            TestReport testReport = testRespository.queryTestReportByTestTradeId(testTradeId);
            if(testReport == null){
                return ResponseUtil.error(404, "相关报价单不存在");
            }
            File file = FileUtil.exportTestReport(testReport ,String.valueOf(testTradeId) + "_报告单.pdf");
            if(file.exists()){
                FileInputStream inputStream = new FileInputStream(file);
                response.setHeader("content-disposition", "inline;fileName=" + URLEncoder.encode("检测报告", "UTF-8"));
                response.setContentType("application/x-msdownload");
                ServletOutputStream outputStream = response.getOutputStream();
                IOUtils.copy(inputStream, outputStream);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(outputStream);
                JSONObject downloadResult = new JSONObject(true);
                downloadResult.put("fileName", "检测报告");
                downloadResult.put("msg", "下载成功");
                return ResponseUtil.success(downloadResult);
            }
            return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
        }catch (Exception e){
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    /*@Override
    public ResponseVO<?> auditTestApply(Long testTradeId, String testTradeStatus,
        MultipartFile[] applyFileList, MultipartFile[] payFileList) {
        try {
            //上传附件
            String dir1 = getTestApplicationFormPDFDir(String.valueOf(testTradeId));
            String dir2 = getTestApplicationFormImageDir(String.valueOf(testTradeId));
            recurseDelFile(dir1);
            recurseDelFile(dir2);
            uploadToFileDir(dir1, applyFileList);
            uploadToFileDir(dir2, payFileList);
            updateTestTradeStatus(testTradeId, testTradeStatus);
            //更新财务表
          TestQuotation testQuotation = testRespository.queryTestQuotationByTestTradeId(
              testTradeId);
          TestApplicationForm testApplicationForm = testRespository.queryTestApplicationFormByTestTradeId(
                testTradeId);
            Finance finance = new Finance();
            finance.setTradeId(testTradeId);
            finance.setType("检测交易");
            finance.setClient(testApplicationForm.getCustomer());
            finance.setApplyDate(testApplicationForm.getApplicationDate());
            finance.setProDate(testApplicationForm.getApplicationDate());
          finance.setPrice(testQuotation.getTotalCost());
          // 自动填写报价单编号、报告单编号、是否分包
          finance.setReportNum(testApplicationForm.getReportNum());
          finance.setProNum(testQuotation.getQuotationNum()); // 协议号为报价单编号
          finance.setAgreeToSubcontract(testApplicationForm.getAgreeToSubcontract());
            financeRepository.insert(finance);
            JSONObject downloadResult = new JSONObject(true);
            downloadResult.put("msg", "上传附件及更新财务表成功");
            return ResponseUtil.success(downloadResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    @Override
    public ResponseVO<?> downloadTestAuditFileAsZip(HttpServletResponse response, Long testTradeId,
        String part) {
        try {
            //setting headers
            response.setStatus(HttpServletResponse.SC_OK);
            response.addHeader("Content-Disposition", "attachment; filename=" +
                testTradeId + "_" + part + ".zip");
            ZipOutputStream zipOutputStream = new ZipOutputStream(response.getOutputStream());
            // create a list to add files to be zipped
            String fileDirStr = "1".equals(part) ?
                getTestApplicationFormPDFDir(String.valueOf(testTradeId)) :
                getTestApplicationFormImageDir(String.valueOf(testTradeId));
            File fileDir = new File(fileDirStr);
            if (!fileDir.exists() || !fileDir.isDirectory()) {
                return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
            }
            // package files
            File[] files = fileDir.listFiles();
            if (files == null) {
                return ResponseUtil.error(ErrorCodeEnum.NOT_FOUND);
            }
            for (File file : files) {
                //new zip entry and copying inputstream with file to zipOutputStream, after all closing streams
                zipOutputStream.putNextEntry(new ZipEntry(file.getName()));
                FileInputStream fileInputStream = new FileInputStream(file);
                IOUtils.copy(fileInputStream, zipOutputStream);
                fileInputStream.close();
                zipOutputStream.closeEntry();
            }
            zipOutputStream.close();
            return ResponseUtil.success();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

  /*@Override
  public ResponseEntity<?> previewTestQuotationByTestTradeId(Long testTradeId) {
      try {
          TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
          if (testTrade == null) {
              return new ResponseEntity<>(new LibiaoException("相关检测交易不存在"), HttpStatus.NOT_FOUND);
          }
          TestQuotation testQuotation = testRespository.queryTestQuotationByTestTradeId(
              testTradeId);
          if (testQuotation == null) {
              return new ResponseEntity<>(new LibiaoException("请求的报价单不存在"), HttpStatus.NOT_FOUND);
          }
          String outPath = testTradeId + "_报价单.pdf";
          File file = FileUtil.exportTestQuotation(testQuotation, outPath);
          FileInputStream fileInputStream = new FileInputStream(file);
          HttpHeaders headers = new HttpHeaders();
          headers.add("content-disposition", "inline;filename=" + file.getName());
          return ResponseEntity
              .ok()
              .headers(headers)
              .contentLength(file.length())
              .contentType(MediaType.parseMediaType("application/pdf"))
              .body(new InputStreamResource(fileInputStream));
      } catch (Exception e) {
          return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
              HttpStatus.INTERNAL_SERVER_ERROR);
      }
  }*/

    /*@Override
    public ResponseEntity<?> previewTestApplyByTestTradeId(Long testTradeId) {
        try {
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if (testTrade == null) {
                return new ResponseEntity<>(new LibiaoException("相关检测交易不存在"), HttpStatus.NOT_FOUND);
            }
            TestApplicationForm testApplicationForm = testRespository.queryTestApplicationFormByTestTradeId(
                testTradeId);
            if (testApplicationForm == null) {
                return new ResponseEntity<>(new LibiaoException("请求的申请单不存在"), HttpStatus.NOT_FOUND);
            }
            String outPath = testTradeId + "_申请单.pdf";
            File file = FileUtil.exportTestApplicationForm(testApplicationForm, outPath);
            FileInputStream fileInputStream = new FileInputStream(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-disposition", "inline;filename=" + file.getName());
            return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(fileInputStream));
        } catch (Exception e) {
            return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    /*@Override
    public ResponseEntity<?> previewTestWorkOrderByTestTradeId(Long testTradeId) {
        try {
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if (testTrade == null) {
                return new ResponseEntity<>(new LibiaoException("相关检测交易不存在"), HttpStatus.NOT_FOUND);
            }
            TestWorkOrder testWorkOrder = testRespository.queryTestWorkOrderByTestTradeId(
                testTradeId);
            if (testWorkOrder == null) {
                return new ResponseEntity<>(new LibiaoException("请求的工作单不存在"), HttpStatus.NOT_FOUND);
            }
            String outPath = testTradeId + "_工作单.pdf";
            File file = FileUtil.exportTestWorkOrder(testWorkOrder, outPath);
            FileInputStream fileInputStream = new FileInputStream(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-disposition", "inline;filename=" + file.getName());
            return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(fileInputStream));
        } catch (Exception e) {
            return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }*/

    @Override
    public ResponseEntity<?> previewTestReportByTestTradeId(Long testTradeId) {
        try {
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if (testTrade == null) {
                return new ResponseEntity<>(new LibiaoException("相关检测交易不存在"), HttpStatus.NOT_FOUND);
            }
            TestReport testReport = testRespository.queryTestReportByTestTradeId(
                testTradeId);
            if (testReport == null) {
                return new ResponseEntity<>(new LibiaoException("请求的报告单不存在"), HttpStatus.NOT_FOUND);
            }
            String outPath = testTradeId + "_报告单.pdf";
            File file = FileUtil.exportTestReport(testReport, outPath);
            FileInputStream fileInputStream = new FileInputStream(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add("content-disposition", "inline;filename=" + file.getName());
            return ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/pdf"))
                .body(new InputStreamResource(fileInputStream));
        } catch (Exception e) {
            return new ResponseEntity(new LibiaoException(ErrorCodeEnum.UNKNOWN_ERROR),
                HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseVO deleteTestQuotation(Long testQuotationId) {
        try {
            int affected_rows = testRespository.deleteTestQuotationById(testQuotationId);
            JSONObject delResult = new JSONObject(true);
            delResult.put("delStatus", true);
            delResult.put("affected_rows", affected_rows);
            delResult.put("msg", "删除检测报价单成功.");
            return ResponseUtil.success(delResult);
        } catch (Exception e) {
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    /*@Override
    public ResponseVO updateTestApply(TestApplicationForm testApply) {
        try {
            if (testApply.getId() == null) {
                return ResponseUtil.error(412, "上传的参数缺少id");
            }
            Long testTradeId = testApply.getTestTradeId();
            TestApplicationForm oldTestApply = testRespository.queryTestApplicationFormByTestTradeId(
                testTradeId);
            if (oldTestApply == null) {
                return ResponseUtil.error(404, "相关检测申请单没有找到，更新失败");
            }
            testRespository.updateTestApplyByPrimaryKey(testApply);
            List<TestApplicationItem> oldList = oldTestApply.getTestApplicationItemList();
            if (!CollectionUtils.isEmpty(oldList)) {
                for (TestApplicationItem testApplicationItem : oldList) {
                    testRespository.deleteTestApplicationItemById(testApplicationItem.getId());
                }
            }
            List<TestApplicationItem> newList = testApply.getTestApplicationItemList();
            if (!CollectionUtils.isEmpty(newList)) {
                for (TestApplicationItem testApplicationItem : newList) {
                    testApplicationItem.setId(null);
                    testApplicationItem.setTestApplicationFormId(testApply.getId());
                    testRespository.insertTestApplicationItem(testApplicationItem);
                }
            }

            JSONObject updateResult = new JSONObject();
            updateResult.put("id", testTradeId);
            updateResult.put("msg", "检测交易更新成功");
            return ResponseUtil.success(updateResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    @Override
    public ResponseVO deleteTestApply(Long testApplyId) {
        try {
            int affected_rows = testRespository.deleteTestApplyById(testApplyId);
            JSONObject delResult = new JSONObject(true);
            delResult.put("delStatus", true);
            delResult.put("affected_rows", affected_rows);
            delResult.put("msg", "删除检测申请单成功.");
            return ResponseUtil.success(delResult);
        } catch (Exception e) {
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    /*@Override
    public ResponseVO updateTestWorkOrder(TestWorkOrder testWorkOrder) {
        try {
            if (testWorkOrder.getId() == null) {
                return ResponseUtil.error(412, "上传的参数缺少id");
            }
            Long testTradeId = testWorkOrder.getTestTradeId();
            TestWorkOrder oldTestWorkOrder = testRespository.queryTestWorkOrderByTestTradeId(
                testTradeId);
            if (oldTestWorkOrder == null) {
                return ResponseUtil.error(404, "相关检测工作单没有找到，更新失败");
            }
            testRespository.updateTestWorkOrderByPrimaryKey(testWorkOrder);
            List<TestWorkOrderItem> oldList = oldTestWorkOrder.getTestWorkOrderItemList();
            if (!CollectionUtils.isEmpty(oldList)) {
                for (TestWorkOrderItem testWorkOrderItem : oldList) {
                    testRespository.deleteTestWorkOrderItemById(testWorkOrderItem.getId());
                }
            }
            List<TestWorkOrderItem> newList = testWorkOrder.getTestWorkOrderItemList();
            if (!CollectionUtils.isEmpty(newList)) {
                for (TestWorkOrderItem testWorkOrderItem : newList) {
                    testWorkOrderItem.setId(null);
                    testWorkOrderItem.setTestWorkOrderId(testWorkOrder.getId());
                    testRespository.insertTestWorkOrderItem(testWorkOrderItem);
                }
            }

            // 更新用户访问权限
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTradeId,
                ROLE_TEST);
            userTestTradeRepository.insert(testWorkOrder.getTestId(), testTradeId);
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTradeId,
                ROLE_AUDIT_1);
            userTestTradeRepository.insert(testWorkOrder.getEditorId(), testTradeId);
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTradeId,
                ROLE_AUDIT_2);
            userTestTradeRepository.insert(testWorkOrder.getReviewerId(), testTradeId);
            userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTradeId,
                ROLE_AUDIT_3);
            userTestTradeRepository.insert(testWorkOrder.getApproverId(), testTradeId);

            JSONObject updateResult = new JSONObject();
            updateResult.put("id", testTradeId);
            updateResult.put("msg", "检测交易更新成功");
            return ResponseUtil.success(updateResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }*/

    @Override
    public ResponseVO deleteTestWorkOrder(Long testWorkOrderId) {
        try {
            int affected_rows = testRespository.deleteTestWorkOrderById(testWorkOrderId);
            JSONObject delResult = new JSONObject(true);
            delResult.put("delStatus", true);
            delResult.put("affected_rows", affected_rows);
            delResult.put("msg", "删除检测工作单成功.");
            return ResponseUtil.success(delResult);
        } catch (Exception e) {
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO updateTestReport(String testReportStr, MultipartFile[] imgList) {
        try {
          TestReport testReport = JSON.parseObject(testReportStr, TestReport.class);
            if (testReport.getId() == null) {
                return ResponseUtil.error(412, "上传的参数缺少id");
            }
            TestReport oldTestReport = testRespository.selectTestReportById(
                testReport.getId());
            if (oldTestReport == null) {
                return ResponseUtil.error(404, "相关检测报告单没有找到，更新失败");
            }
            testRespository.updateTestReportByPrimaryKey(testReport);

            Long testTradeId = Long.valueOf(testReport.getTestTradeId());

          //上传附件
          if (ArrayUtils.isNotEmpty(imgList)) {
            String dir1 = getTestReportSampleImageDir(String.valueOf(testTradeId));
            recurseDelFile(dir1);
            uploadToFileDir(dir1, imgList);
          }

            JSONObject updateResult = new JSONObject();
            updateResult.put("id", testTradeId);
            updateResult.put("msg", "检测交易更新成功");
            return ResponseUtil.success(updateResult);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO deleteTestReport(Long testReportId) {
        try {
            int affected_rows = testRespository.deleteTestReportById(testReportId);
            JSONObject delResult = new JSONObject(true);
            delResult.put("delStatus", true);
            delResult.put("affected_rows", affected_rows);
            delResult.put("msg", "删除检测报告单成功.");
            return ResponseUtil.success(delResult);
        } catch (Exception e) {
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

    @Override
    public ResponseVO<?> getTestTradeStatus(Long testTradeId) {
        try {
            TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
            if (Objects.isNull(testTrade)) {
                return ResponseUtil.error(404, "未找到检测交易");
            }
            JSONObject result = new JSONObject(true);
            result.put("testTradeId", testTradeId);
            result.put("status", testTrade.getStatus());
            result.put("msg", "成功");
            return ResponseUtil.success(result);
        } catch (Exception e) {
            return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
        }
    }

  @Override
  public ResponseVO<?> getTestReportSampleImages(Long tradeId) {
    try {
      String path = getTestReportSampleImageDir(String.valueOf(tradeId));
      File file = new File(path);
      File[] files = file.listFiles();
      if (files == null || files.length == 0) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("msg", "未找到样品照片");
        return ResponseUtil.success(jsonObject);
      }
      ArrayList<FileVO> fileVOs = Lists.newArrayList();
      for (File f : files) {
        FileVO fileVO = new FileVO();
        fileVO.setName(f.getName());
        fileVO.setPath(path);
        fileVOs.add(fileVO);
      }
      JSONObject jsonObject = new JSONObject();
      jsonObject.put("data", fileVOs);
      jsonObject.put("msg", "获取样品照片成功");
      return ResponseUtil.success(jsonObject);
    } catch (Exception e) {
      e.printStackTrace();
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }

  /**
   * 给检测交易指派客服人员
   * @param testTradeId 检测交易id
   * @param serviceId 客服人员id
   * @return
   */
  /*@Override
  public ResponseVO updateTestCustomService(Long testTradeId, Long serviceId) {
    try {
      TestTrade testTrade = testRespository.selectTestTradeById(testTradeId);
      if (testTrade == null) {
        return ResponseUtil.error(404, "相关检测交易没有找到，指派客服人员失败");
      }
      TestQuotation testQuotation = testRespository.queryTestQuotationByTestTradeId(
          testTradeId);
      if (testQuotation == null) {
        return ResponseUtil.error(404, "相关报价单没有找到，指派客服人员失败");
      }
      TestApplicationForm testApplicationForm = testRespository.queryTestApplicationFormByTestTradeId(
          testTradeId);
      if (testApplicationForm == null) {
        return ResponseUtil.error(404, "相关申请单没有找到，指派客服人员失败");
      }
      // 更新填过客服的地方
      UserExt user = userRepository.selectByPrimaryKey(serviceId);
      String nickname = user.getNickname();
      testQuotation.setServiceId(serviceId);
      testQuotation.setAttn(nickname);
      testApplicationForm.setCsName(nickname);
      testRespository.updateTestQuotationByPrimaryKey(testQuotation);
      testRespository.updateTestApplyByPrimaryKey(testApplicationForm);

      // 更新用户访问权限
      updateTestParticipantByRole(testTradeId, serviceId, ROLE_CUSTOM_SERVICE);
      JSONObject result = new JSONObject();
      result.put("msg", "指定客服成功");
      return ResponseUtil.success(result);
    } catch (Exception e) {
      return ResponseUtil.error(ErrorCodeEnum.UNKNOWN_ERROR);
    }
  }*/

  /**
   * 更新检测交易参与人员，包括客户、销售、客服、测试、编校审等，
   * 只有参与人员才能看到对应检测交易
   * @param testTradeId 检测交易id
   * @param userId 参与人员id
   * @param role
   */
  private void updateTestParticipantByRole(Long testTradeId, Long userId, String role) {
    userTestTradeRepository.deleteAllPermissionByTestTradeIdAndRole(testTradeId, role);
    userTestTradeRepository.insert(userId, testTradeId);
  }
}
