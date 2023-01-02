package com.libiao.customer.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.service.TestBizService;
import com.libiao.customer.util.model.ResponseVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 检测交易
 */

@RestController
@RequestMapping(value = "/api/test")
public class TestTradeCtrl {

    /**
     * 报价单，申请表，工作单，检测报告
     */

    @Autowired
    private TestBizService testBizService;

    /**
     * 保存检测交易
     */
    @ResponseBody
    @RequestMapping(value="/saveTestTrade", method = RequestMethod.POST)
    public ResponseVO saveTestTrade(@RequestBody TestTrade testTrade){
        return testBizService.saveTestTrade(testTrade);
    }

    /**
     * 更新检测交易状态
     */
    @ResponseBody
    @RequestMapping(value = "/updateTestTrade", method = RequestMethod.POST)
    public ResponseVO updateTestTrade(@RequestBody TestTrade testTrade){
        return testBizService.updateTestTrade(testTrade);
    }

    @ResponseBody
    @RequestMapping(value = "/updateTestTrade/status", method = RequestMethod.POST)
    public ResponseVO updateTestTradeStatus(@RequestParam("testTradeId") Long testTradeId, @RequestParam("status") String status){
        return testBizService.updateTestTradeStatus(testTradeId, status);
    }

    /**
     * 删除检测交易
     */
    @ResponseBody
    @RequestMapping(value = "/deleteTestTrade", method = RequestMethod.DELETE)
    public ResponseVO deleteTestTrade(@RequestParam("testTradeId") Long testTradeId){
        return testBizService.deleteTestTrade(testTradeId);
    }

    /**
     * 查询检测交易列表
     */
    @ResponseBody
    @RequestMapping(value = "/queryTestTradeList", method = RequestMethod.GET)
    public ResponseVO queryTestTradeList(@RequestParam(name="pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize,
                                         @RequestParam(name="testName", required = false) String testName,
                                         @RequestParam(name="client", required = false) String client,
                                         @RequestParam(name="status", required = false) String status){
        return testBizService.queryTestTradeList(pageNum, pageSize, testName, client, status);
    }


    /**
     * 保存报价单
     */
    /*@ResponseBody
    @RequestMapping(value = "/saveTestQuotation", method = RequestMethod.POST)
    public ResponseVO saveTestQuotation(@RequestBody TestQuotation testQuotation){
        return testBizService.saveTestQuotation(testQuotation);
    }*/

    /**
     * 更新报价单
     */
    /*@ResponseBody
    @RequestMapping(value = "/updateTestQuotation", method = RequestMethod.POST)
    public ResponseVO updateTestQuotation(@RequestBody TestQuotation testQuotation){
        return testBizService.updateTestQuotation(testQuotation);
    }*/

  /**
   * 删除报价单
   */
  @ResponseBody
  @RequestMapping(value = "/deleteTestQuotation", method = RequestMethod.DELETE)
  public ResponseVO deleteTestQuotation(@RequestParam("testQuotationId") Long testQuotationId){
    return testBizService.deleteTestQuotation(testQuotationId);
  }

    /**
     * 根据TestTradeId查询报价单
     * @param testTradeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryTestQuotationByTestTradeId", method = RequestMethod.GET)
    public ResponseVO queryTestQuotationByTestTradeId(@RequestParam("testTradeId") Long testTradeId){
        return testBizService.queryTestQuotationByTestTradeId(testTradeId);
    }

    /**
     * 根据TestTradeId查询申请表
     * @param testTradeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryTestApplicationFormByTestTradeId", method = RequestMethod.GET)
    public ResponseVO queryTestApplicationFormByTestTradeId(@RequestParam("testTradeId") Long testTradeId){
        return testBizService.queryTestApplicationFormByTestTradeId(testTradeId);
    }

    /**
     * 根据TestTradeId查询工作单
     * @param testTradeId
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryTestWorkOrderByTestTradeId", method = RequestMethod.GET)
    public ResponseVO queryTestWorkOrderByTestTradeId(@RequestParam("testTradeId") Long testTradeId){
        return testBizService.queryTestWorkOrderByTestTradeId(testTradeId);
    }
    /**
     * 查询报价单
     */
    /*@ResponseBody
    @RequestMapping(value = "/queryTestQuotationList", method = RequestMethod.GET)
    public ResponseVO queryTestQuotationList(@RequestParam(name="pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize){
        return testBizService.queryTestQuotationList(pageNum, pageSize);
    }*/



    /**
     * 报价单生成pdf
     */
    /*@ResponseBody
    @RequestMapping(value = "/downloadTestQuotation", method = RequestMethod.GET)
    public ResponseVO exportTestQuotation(HttpServletResponse response,
        @RequestParam(name = "testTradeId", required = true) Long testTradeId){
        return testBizService.exportTestQuotation(response, testTradeId);
    }*/

  /**
   * 预览检测报价单
   * @param testTradeId
   * @return
   */
  /*@ResponseBody
    @RequestMapping(value = "/previewTestQuotation", method = RequestMethod.GET)
    public ResponseEntity<?> previewTestQuotation(@RequestParam("testTradeId") Long testTradeId){
        return testBizService.previewTestQuotationByTestTradeId(testTradeId);
    }*/

    /**
     * 保存申请表
     */
    /*@ResponseBody
    @RequestMapping(value = "/saveTestApplicationForm", method = RequestMethod.POST)
    public ResponseVO saveTestApplicationForm(@RequestBody TestApplicationForm testApplicationForm){
        return testBizService.saveTestApplicationForm(testApplicationForm);
    }*/


    /**
     * 查询申请表
     */
    /*@ResponseBody
    @RequestMapping(value = "/queryTestApplicationFormList", method = RequestMethod.GET)
    public ResponseVO queryTestApplicationFormList(@RequestParam(name="pageNum", required = false, defaultValue = "1") int pageNum,
                                               @RequestParam(name="pageSize", required = false, defaultValue = "10") int pageSize){
        return testBizService.queryTestApplicationFormList(pageNum, pageSize);
    }*/

  /**
   * 更新申请单
   */
  /*@ResponseBody
  @RequestMapping(value = "/updateTestApply", method = RequestMethod.POST)
  public ResponseVO updateTestApply(@RequestBody TestApplicationForm testApply){
    return testBizService.updateTestApply(testApply);
  }*/

  /**
   * 删除申请单
   */
  @ResponseBody
  @RequestMapping(value = "/deleteTestApply", method = RequestMethod.DELETE)
  public ResponseVO deleteTestApply(@RequestParam("testApplyId") Long testApplyId){
    return testBizService.deleteTestApply(testApplyId);
  }

    /**
     * 申请表生成pdf
     */
    /*@ResponseBody
    @RequestMapping(value = "/downloadTestApplicationForm", method = RequestMethod.GET)
    public ResponseVO downloadTestApplicationForm( HttpServletResponse response,
            @RequestParam(name = "testTradeId", required = true) Long testTradeId){
        return testBizService.exportTestApplicationForm(response, testTradeId);
    }*/

  /**
   * 预览检测申请单
   * @param testTradeId
   * @return
   */
  /*@ResponseBody
  @RequestMapping(value = "/previewTestApply", method = RequestMethod.GET)
  public ResponseEntity<?> previewTestApply(@RequestParam("testTradeId") Long testTradeId){
    return testBizService.previewTestApplyByTestTradeId(testTradeId);
  }*/

    /**
     * 保存工作单
     */

    /*@ResponseBody
    @RequestMapping(value = "/saveTestWorkOrder", method = RequestMethod.POST)
    public ResponseVO saveTestWorkOrder(@RequestBody TestWorkOrder testWorkOrder){
        return testBizService.saveTestWorkOrder(testWorkOrder);
    }*/

    /**
     * 查询工作单
     */
    /*@ResponseBody
    @RequestMapping(value = "/queryTestWordOrderList", method = RequestMethod.GET)
    public ResponseVO queryTestWorkOrderList(@RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
                                         @RequestParam(name = "pageSize", required = false, defaultValue = "2") int pageSize){
        return testBizService.queryTestWorkOrderList(pageNum, pageSize);
    }*/

  /**
   * 更新工作单
   */
  /*@ResponseBody
  @RequestMapping(value = "/updateTestWorkOrder", method = RequestMethod.POST)
  public ResponseVO updateTestWorkOrder(@RequestBody TestWorkOrder testWorkOrder){
    return testBizService.updateTestWorkOrder(testWorkOrder);
  }*/

  /**
   * 删除工作单
   */
  /*@ResponseBody
  @RequestMapping(value = "/deleteTestWorkOrder", method = RequestMethod.DELETE)
  public ResponseVO deleteTestWorkOrder(@RequestParam("testWorkOrderId") Long testWorkOrderId){
    return testBizService.deleteTestWorkOrder(testWorkOrderId);
  }*/

    /**
     * 工作单生成pdf
     */
    /*@ResponseBody
    @RequestMapping(value = "/downloadTestWorkOrder", method = RequestMethod.GET)
    public ResponseVO downloadTestWorkOrder(HttpServletResponse response,
                                          @RequestParam(name = "testTradeId", required = true) Long testTradeId){
        return testBizService.exportTestWorkOrder(response, testTradeId);
    }*/

  /**
   * 预览检测工作单
   * @param testTradeId
   * @return
   */
  /*@ResponseBody
  @RequestMapping(value = "/previewTestWorkOrder", method = RequestMethod.GET)
  public ResponseEntity<?> previewTestWorkOrder(@RequestParam("testTradeId") Long testTradeId){
    return testBizService.previewTestWorkOrderByTestTradeId(testTradeId);
  }*/

    /**
     * 根据检测交易单id，返回对应的检测交易单，报价单，申请单，以及工作单
     */
    /*@ResponseBody
    @RequestMapping(value = "/queryAllFormByTestTradeId", method = RequestMethod.GET)
    public ResponseVO queryAllFormByTestTradeId(@RequestParam(name="testTradeId", required = true) Long testTradeId){
        return testBizService.queryAllFormByTestTradeId(testTradeId);
    }*/

    @ResponseBody
    @RequestMapping(value = "/saveTestReport", method = RequestMethod.POST)
    public ResponseVO saveTestReport(
        @RequestParam("postForm") String testReport,
        @RequestParam("imgList") MultipartFile[] imgList){
        return testBizService.saveTestReport(testReport, imgList);
    }

    /**
     * 查询报告单列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/queryTestReportList", method = RequestMethod.GET)
    public ResponseVO<?> queryTestReportList(
        @RequestParam(name = "pageNum", required = false, defaultValue = "1") int pageNum,
        @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        return testBizService.queryTestReportList(pageNum, pageSize);
    }

  /**
   * 更新报告单
   */
  @ResponseBody
  @RequestMapping(value = "/updateTestReport", method = RequestMethod.POST)
  public ResponseVO updateTestReport(
      @RequestParam("postForm") String testReport,
      MultipartFile[] imgList){
    return testBizService.updateTestReport(testReport, imgList);
  }

  /**
   * 删除报告单
   */
  @ResponseBody
  @RequestMapping(value = "/deleteTestReport", method = RequestMethod.DELETE)
  public ResponseVO deleteTestReport(@RequestParam("testReportId") Long testReportId){
    return testBizService.deleteTestReport(testReportId);
  }

  /**
   * 预览检测报告单
   * @param testTradeId
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/previewTestReport", method = RequestMethod.GET)
  public ResponseEntity<?> previewTestReport(@RequestParam("testTradeId") Long testTradeId){
    return testBizService.previewTestReportByTestTradeId(testTradeId);
  }

    /** 确认测试报价单
     * 发送报价单给客户, 系统发送、邮件发送，同步给客服。（代劳客户录入申请单）
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/confirmTestQuotation",method = RequestMethod.POST)
    public ResponseVO sentTestQuotationToCustomer(@RequestBody JSONObject message){
        Long testTradeId = message.getLong("testTradeId"); // 报价单
        Long customerId = message.getLong("customerId"); // 客户
        Long serviceStaffId = message.getLong("serviceStaffId"); // 客服ID
        return testBizService.confirmTestQuotation(serviceStaffId, testTradeId,  customerId);
    }

    /**
     * 客户【客服代劳】上传签字或者盖章的申请单的pdf
     */
    @ResponseBody
    @RequestMapping(value="/uploadTestApplicationForm", method = RequestMethod.POST)
    public ResponseVO uploadTestApplicationForm(@RequestParam("file")MultipartFile file, @RequestParam("testTradeId") Long testTradeId){
        return testBizService.uploadTestApplicationForm(file, testTradeId);
    }

    /**
     * 确认完成付款, 推送给财务。
     */
    @ResponseBody
    @RequestMapping(value = "/confirmTestApplicationFormPayment", method = RequestMethod.POST)
    public ResponseVO confirmTestApplicationFormPayment(@RequestBody JSONObject message){
        Long testTradeId = message.getLong("testTradeId");
        Long financialStaffId= message.getLong("financialStaffId");
        return testBizService.confirmTestApplicationFormPayment(testTradeId, financialStaffId);
    }

    /**
     * 确认工作单
     * 将客服创建的工作单发送给检测人员【系统，邮件发送】
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/confirmTestWorkOrder", method = RequestMethod.POST)
    public ResponseVO confirmTestWorkOrder(@RequestBody JSONObject message){
        Long testTradeId = message.getLong("testTradeId");
        Long testingStaffId = message.getLong("testingStaffId");
        return testBizService.confirmTestWorkOrder(testTradeId, testingStaffId);
    }

    /**
     * 确认检测报告
     * @param message
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/confirmTestReport", method = RequestMethod.POST)
    public ResponseVO confirmTestReport(@RequestBody JSONObject message){
        Long testTradeId = message.getLong("testTradeId");
        JSONArray userJSONArray = message.getJSONArray("checkers"); // 获取数组
        String userListStr = JSONObject.toJSONString(userJSONArray, SerializerFeature.WriteClassName); // 转为字符串
        List<UserExt> userExtList = JSONObject.parseArray(userListStr, UserExt.class);
        return testBizService.confirmTestReport(testTradeId, userExtList);
    }

    @ResponseBody
    @RequestMapping(value = "/downloadTestReport", method = RequestMethod.GET)
    public void downloadTestReport(HttpServletResponse response,
                                         @RequestParam(name="testTradeId", required = true) Long testTradeId){
//        return testBizService.exportTestReport(response, testTradeId);
        testBizService.exportTestReport(response, testTradeId);
    }

  /**
   * 审核检测申请单
   * @param testTradeId 检测交易id
   * @param testTradeStatus 检测交易状态
   * @param applyFileList 已盖章的申请单pdf文件
   * @param payFileList 付款单截图
   * @return
   */
    /*@ResponseBody
    @RequestMapping(value = "/auditTestApply", method = RequestMethod.POST)
    public ResponseVO<?> auditTestApply(
        @RequestParam("testTradeId") Long testTradeId,
        @RequestParam("testTradeStatus") String testTradeStatus,
        @RequestParam("applyFileList") MultipartFile[] applyFileList,
        @RequestParam("payFileList") MultipartFile[] payFileList){
        return testBizService.auditTestApply(testTradeId, testTradeStatus, applyFileList, payFileList);
    }*/

  /**
   * 打包下载审核时上传的文件
   * @param response
   * @param testTradeId 检测交易id
   * @param part part=1为已盖章的申请单pdf，part=2为付款截图
   */
    @RequestMapping(value="/downloadAuditPart", produces="application/zip", method = RequestMethod.GET)
    public void downloadTestAuditFileAsZip(HttpServletResponse response,
        @RequestParam("testTradeId") Long testTradeId, @RequestParam("part") String part) {
        testBizService.downloadTestAuditFileAsZip(response, testTradeId, part);
    }

  /**
   * 获取检测交易状态
   * @param testTradeId
   * @return
   */
  @ResponseBody
  @RequestMapping(value = "/getTestTradeStatus", method = RequestMethod.GET)
  public ResponseVO<?> getTestTradeStatus(@RequestParam("testTradeId") Long testTradeId){
    return testBizService.getTestTradeStatus(testTradeId);
  }

  @ResponseBody
  @RequestMapping(value = "/test-report-image", method = RequestMethod.GET)
  public ResponseVO<?> getTestReportSampleImages(@RequestParam("testTradeId") Long tradeId){
    return testBizService.getTestReportSampleImages(tradeId);
  }

  /**
   * 为检测交易分配客服
   * @param testTradeId 检测交易id
   * @param serviceId 客服id
   * @return
   */
  /*@ResponseBody
  @RequestMapping(value = "/updateTestCustomService", method = RequestMethod.POST)
  public ResponseVO updateTestCustomService(
      @RequestParam("testTradeId") Long testTradeId,
      @RequestParam("serviceId") Long serviceId){
    return testBizService.updateTestCustomService(testTradeId, serviceId);
  }*/
}
