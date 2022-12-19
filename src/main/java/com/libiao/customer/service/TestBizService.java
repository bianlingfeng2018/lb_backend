package com.libiao.customer.service;

import com.alibaba.fastjson.JSONObject;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.util.model.ResponseVO;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 检测服务
 */

public interface TestBizService {

    ResponseVO saveTestTrade(TestTrade testTrade);

    ResponseVO updateTestTrade(TestTrade testTrade);

    ResponseVO updateTestTradeStatus(Long testTradeId, String status);

    ResponseVO deleteTestTrade(Long testTradeId);

    ResponseVO queryTestTradeList(int pageNum, int pageSize, String testName, String client, String status);

    ResponseVO saveTestQuotation(TestQuotation testQuotation);

    ResponseVO updateTestQuotation(TestQuotation testQuotation);

    ResponseVO queryTestQuotationList(int pageNum, int pageSize);

    ResponseVO exportTestQuotation(HttpServletResponse response, Long testTradeId); // 导出报价单pdf

    ResponseVO saveTestApplicationForm(TestApplicationForm testApplicationForm);

    ResponseVO queryTestApplicationFormList(int pageNum, int pageSize);

    ResponseVO exportTestApplicationForm(HttpServletResponse response, Long testTradeId); // 导出申请单pdf

    ResponseVO saveTestWorkOrder(TestWorkOrder testWorkOrder);

    ResponseVO queryTestWorkOrderList(int pageNum, int pageSize);

    ResponseVO exportTestWorkOrder(HttpServletResponse response, Long testTradeId); // 导出工作单pdf

    ResponseVO queryTestQuotationByTestTradeId(Long testTradeId);

    ResponseVO queryTestApplicationFormByTestTradeId(Long testTradeId);

    ResponseVO queryTestWorkOrderByTestTradeId(Long testTradeId);

    ResponseVO queryAllFormByTestTradeId(Long testTradeId);

    ResponseVO saveTestReport(String testReport, MultipartFile[] imgList);

    ResponseVO queryTestReportList(int pageNum, int pageSize);

    /**
     * 确认报价单
     * @param testTradeId
     * @param customerId
     * @return
     */
    ResponseVO confirmTestQuotation(Long serviceStaffId, Long testTradeId, Long customerId);

    /**
     * 上传申请单
     * @param file
     * @return
     */
    ResponseVO uploadTestApplicationForm(MultipartFile file, Long testTradeId);

    /**
     * 确认申请单付款
     */
    ResponseVO confirmTestApplicationFormPayment(Long testTradeId, Long financialStaffId);

    /**
     * 确认工作单
     */
    ResponseVO confirmTestWorkOrder(Long testTradeId, Long testingStaffId);

    /**
     * 确认检测报告
     */
    ResponseVO confirmTestReport(Long testTradeId, List<User> userList);


    ResponseVO exportTestReport(HttpServletResponse response, Long testTradeId);

    ResponseVO<?> auditTestApply(Long testTradeId, String testTradeStatus, MultipartFile[] applyFileList, MultipartFile[] payFileList);

    ResponseVO<?> downloadTestAuditFileAsZip(HttpServletResponse response, Long testTradeId, String part);

    ResponseEntity<?> previewTestQuotationByTestTradeId(Long testTradeId);

    ResponseEntity<?> previewTestApplyByTestTradeId(Long testTradeId);

    ResponseEntity<?> previewTestWorkOrderByTestTradeId(Long testTradeId);

    ResponseEntity<?> previewTestReportByTestTradeId(Long testTradeId);

    ResponseVO deleteTestQuotation(Long testQuotationId);

    ResponseVO updateTestApply(TestApplicationForm testApply);

    ResponseVO deleteTestApply(Long testApplyId);

    ResponseVO updateTestWorkOrder(TestWorkOrder testWorkOrder);

    ResponseVO deleteTestWorkOrder(Long testWorkOrderId);

    ResponseVO updateTestReport(String testReport, MultipartFile[] imgList);

    ResponseVO deleteTestReport(Long testReportId);

    ResponseVO<?> getTestTradeStatus(Long testTradeId);

    ResponseVO<?> getTestReportSampleImages(Long tradeId);

    ResponseVO updateTestCustomService(Long testTradeId, Long serviceId);
}
