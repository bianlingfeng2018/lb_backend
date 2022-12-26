package com.libiao.customer.repository;

import com.libiao.customer.dal.model.*;
import com.libiao.customer.util.model.ResponseVO;

import java.util.List;

/**
 * 检测
 */

public interface TestRespository {


    /**
    根据测试交易id，删除检测交易
     **/
    public int deleteTestTradeById(Long id);

    /**
     * 新增检测交易
     */
    public int insertTestTrade(TestTrade row);

    /**
     * 更新检测
     */
    public int updateTestTradeByPrimaryKey(TestTrade testTrade);

    /**
     * 根据ID查询检测交易
     */
    public TestTrade selectTestTradeById(Long id);

    /**
     * 查询所有的测试交易
     */
    public List<TestTrade> selectAllTestTrade();

    /**
     * 查询所有和某个人相关的测试交易
     */
    public List<TestTrade> selectAllTestTradeByOwner(String owner);

    /** 插入测试报价单
     * 插入后返回主键
     * @param row
     * @return
     */
    //public int insertTestQuotation(TestQuotation row);

    /**
     * 插入测试报价单子项
     * @return
     */
    public int insertTestQuotationItem(TestQuotationItem testQuotationItem);

    /**
     * 批量插入测试报价单
     * @return
     */
    public int batchInsertQuotationItem(List<TestQuotationItem> testQuotationItemList);

    //public List<TestQuotation> queryTestQuotation(int pageNum, int pageSize);

    public List<TestQuotationItem> queryTestQuotationItemByQuotationId(Long testQuotationId);

    /********************************************* 测试报价单 *********************************************/

    public int insertTestApplicationForm(TestApplicationForm testApplicationForm);

    public int insertTestApplicationItem(TestApplicationItem testApplicationItem);

    public int batchInsertTestApplicationItem(List<TestApplicationItem> testApplicationItemList);

    public List<TestApplicationForm> queryTestApplicationForm(int pageNum, int pageSize);

    public List<TestApplicationItem> queryTestApplicationItemByApplicationFormId(Long testApplicationFormId);

    /********************************************* 测试申请表 *********************************************/

    public int insertTestWorkOrder(TestWorkOrder testWorkOrder);

    public int insertTestWorkOrderItem(TestWorkOrderItem testWorkOrderItem);

    public int batchInsertTestWorkOrderItem(List<TestWorkOrderItem> testWorkOrderItemList);

    public List<TestWorkOrder> queryTestWorkOrder(int pageNum, int pageSize);

    List<TestReport> queryTestReport(int pageNum, int pageSize);

    public List<TestWorkOrderItem> queryTestWorkOrderItemByWorkOrderId(Long testWorkOrderId);
    /********************************************* 测试工作单 *********************************************/

    //public TestQuotation queryTestQuotationByTestTradeId(Long testTradeId);

    public TestApplicationForm queryTestApplicationFormByTestTradeId(Long testTradeId);

    public TestWorkOrder queryTestWorkOrderByTestTradeId(Long testTradeId);

    /********************************************* 测试报告 *********************************************/

    public int insertTestReport(TestReport testReport); // 插入测试报告

    public TestReport queryTestReportByTestTradeId(Long testTradeId); // 查询测试报告


    int deleteTestQuotationById(Long testQuotationId);

    int deleteTestApplyById(Long testApplyId);

    int deleteTestWorkOrderById(Long testWorkOrderId);

    int deleteTestReportById(Long testReportId);

    TestQuotation selectTestQuotationById(Long id);

    void updateTestQuotationByPrimaryKey(TestQuotation testQuotation);

    TestApplicationForm selectTestApplyById(Long id);

    void updateTestApplyByPrimaryKey(TestApplicationForm testApply);

    TestWorkOrder selectTestWorkOrderById(Long id);

    void updateTestWorkOrderByPrimaryKey(TestWorkOrder testWorkOrder);

    TestReport selectTestReportById(Long id);

    void updateTestReportByPrimaryKey(TestReport testReport);

    void updateTestQuotationItemByPrimaryKey(TestQuotationItem testQuotationItem);

    void updateTestApplicationItemByPrimaryKey(TestApplicationItem testApplicationItem);

    void updateTestWorkOrderItemByPrimaryKey(TestWorkOrderItem testWorkOrderItem);

    void deleteTestQuotationItemById(Long id);

    void deleteTestApplicationItemById(Long id);

    void deleteTestWorkOrderItemById(Long id);

  TestReport selectTestReportByReportNum(String reportNum);
}
