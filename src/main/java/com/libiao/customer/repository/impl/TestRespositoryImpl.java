package com.libiao.customer.repository.impl;

import static com.libiao.customer.util.UserRolePermissionUtil.isAdmin;

import com.github.pagehelper.PageHelper;
import com.libiao.customer.dal.mapper.*;
import com.libiao.customer.dal.model.*;
import com.libiao.customer.repository.TestRespository;
import com.libiao.customer.util.WebUtil;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TestRespositoryImpl implements TestRespository {

    @Autowired
    private TestTradeMapper testTradeMapper;

    @Autowired
    private TestQuotationMapper testQuotationMapper;

    @Autowired
    private TestQuotationItemMapper testQuotationItemMapper;

    @Autowired
    private TestApplicationFormMapper testApplicationFormMapper;

    @Autowired
    private TestApplicationItemMapper testApplicationItemMapper;

    @Autowired
    private TestWorkOrderMapper testWorkOrderMapper;

    @Autowired
    private TestWorkOrderItemMapper testWorkOrderItemMapper;

    @Autowired
    private TestReportMapper testReportMapper;


    @Override
    public int deleteTestTradeById(Long id) {
        return testTradeMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insertTestTrade(TestTrade row) {
        Date now = new Date();
        if(row.getGmtCreate() == null){
            row.setGmtCreate(now);
        }
        if(row.getGmtModify() == null){
            row.setGmtModify(now);
        }
        return  testTradeMapper.insert(row);
    }

    @Override
    public int updateTestTradeByPrimaryKey(TestTrade testTrade) {
        return testTradeMapper.updateByPrimaryKey(testTrade);
    }

    @Override
    public TestTrade selectTestTradeById(Long id) {
        return testTradeMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<TestTrade> selectAllTestTrade() {
        return testTradeMapper.selectAll();
    }

    @Override
    public List<TestTrade> selectAllTestTradeByOwner(String owner) {
        return testTradeMapper.selectAllByOwner(owner);
    }

    /*@Override
    public int insertTestQuotation(TestQuotation row) {
        testQuotationMapper.insert(row);
        for(TestQuotationItem item : row.getTestQuotationItemList()){
            item.setTestQuotationId(row.getId());
        }
        return testQuotationItemMapper.batchInsert(row.getTestQuotationItemList());
    }*/

    @Override
    public int insertTestQuotationItem(TestQuotationItem testQuotationItem) {
        return testQuotationItemMapper.insert(testQuotationItem);
    }

    /*@Override
    public int batchInsertQuotationItem(List<TestQuotationItem> testQuotationItemList) {
        return testQuotationItemMapper.batchInsert(testQuotationItemList);
    }*/

    /*@Override
    public List<TestQuotation> queryTestQuotation(int pageNum, int pageSize){
        String userName = WebUtil.getAccessToken().getUsername();
        String permission = WebUtil.getAccessToken().getPermission();
        List<TestQuotation> testQuotationList = null;
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        if(isAdmin(permission)){
            testQuotationList = testQuotationMapper.selectAll();
        }else{
            testQuotationList = testQuotationMapper.selectAllByOwner(userName);
        }
        return testQuotationList;
    }*/

    /*@Override
    public List<TestQuotationItem> queryTestQuotationItemByQuotationId(Long testQuotationId) {
        return testQuotationItemMapper.selectByTestQuotationId(testQuotationId);
    }*/

    /*@Override
    public int insertTestApplicationForm(TestApplicationForm testApplicationForm) {
        testApplicationFormMapper.insert(testApplicationForm);
        for(TestApplicationItem item : testApplicationForm.getTestApplicationItemList()){
            item.setTestApplicationFormId(testApplicationForm.getId());
        }
        return testApplicationItemMapper.batchInsert(testApplicationForm.getTestApplicationItemList());
    }*/

    @Override
    public int insertTestApplicationItem(TestApplicationItem testApplicationItem) {
        return testApplicationItemMapper.insert(testApplicationItem);
    }

    /*@Override
    public int batchInsertTestApplicationItem(List<TestApplicationItem> testApplicationItemList) {
        return testApplicationItemMapper.batchInsert(testApplicationItemList);
    }*/

    /*@Override
    public List<TestApplicationForm> queryTestApplicationForm(int pageNum, int pageSize) {
        String userName = WebUtil.getAccessToken().getUsername();
        String permission = WebUtil.getAccessToken().getPermission();
        List<TestApplicationForm> testApplicationForms = null;
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        if(isAdmin(permission)){
            testApplicationForms = testApplicationFormMapper.selectAll();
        }else{
            testApplicationForms = testApplicationFormMapper.selectAllByOwner(userName); // 根据用户来
        }
        return testApplicationForms;
    }*/

    /*@Override
    public List<TestApplicationItem> queryTestApplicationItemByApplicationFormId(Long testApplicationFormId) {
        return testApplicationItemMapper.selectByTestApplicationFormId(testApplicationFormId);
    }*/

    /*@Override
    public int insertTestWorkOrder(TestWorkOrder testWorkOrder) {
        testWorkOrderMapper.insert(testWorkOrder);
        for(TestWorkOrderItem item: testWorkOrder.getTestWorkOrderItemList()){
            item.setTestWorkOrderId(testWorkOrder.getId());
        }
        return testWorkOrderItemMapper.batchInsert(testWorkOrder.getTestWorkOrderItemList());
    }*/

    /*@Override
    public int insertTestWorkOrderItem(TestWorkOrderItem testWorkOrderItem) {
        return testWorkOrderItemMapper.insert(testWorkOrderItem);
    }*/

    /*@Override
    public int batchInsertTestWorkOrderItem(List<TestWorkOrderItem> testWorkOrderItemList) {
        return testWorkOrderItemMapper.batchInsert(testWorkOrderItemList);
    }*/

    /*@Override
    public List<TestWorkOrder> queryTestWorkOrder(int pageNum, int pageSize) {
        String userName = WebUtil.getAccessToken().getUsername();
        String permission = WebUtil.getAccessToken().getPermission();
        List<TestWorkOrder> testWorkOrderList = null;
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        if(isAdmin(permission)){
            testWorkOrderList = testWorkOrderMapper.selectAll();
        }else{
            testWorkOrderList = testWorkOrderMapper.selectAllByOwner(userName);
        }
        return testWorkOrderList;
    }*/

    /*@Override
    public List<TestReport> queryTestReport(int pageNum, int pageSize) {
        String userName = WebUtil.getAccessToken().getUsername();
        String permission = WebUtil.getAccessToken().getPermission();
        List<TestReport> testReportList = null;
        PageHelper.startPage(pageNum, pageSize);
        PageHelper.orderBy("id desc");
        if (isAdmin(permission)) {
            testReportList = testReportMapper.selectAll();
        } else {
            testReportList = testReportMapper.selectAllByOwner(userName);
        }
        return testReportList;
    }*/

    /*@Override
    public List<TestWorkOrderItem> queryTestWorkOrderItemByWorkOrderId(Long testWorkOrderId) {
        return testWorkOrderItemMapper.selectByTestWorkOrderId(testWorkOrderId);
    }*/

    /*@Override
    public TestQuotation queryTestQuotationByTestTradeId(Long testTradeId) {
        List<TestQuotation> testQuotationList = testQuotationMapper.queryTestQuotationByTestTradeId(testTradeId);
        if(testQuotationList != null && testQuotationList.size() != 0){
            TestQuotation testQuotation = testQuotationList.get(0);
            testQuotation.setTestQuotationItemList(testQuotationItemMapper.selectByTestQuotationId(testQuotation.getId()));
            return testQuotation;
        }
        return null;
    }*/

    /*@Override
    public TestApplicationForm queryTestApplicationFormByTestTradeId(Long testTradeId) {
        List<TestApplicationForm> testApplicationFormList = testApplicationFormMapper.queryTestApplicationFormByTestTradeId(testTradeId);
        if(testApplicationFormList != null && testApplicationFormList.size() != 0){
            TestApplicationForm testApplicationForm =  testApplicationFormList.get(0);
            testApplicationForm.setTestApplicationItemList(testApplicationItemMapper.selectByTestApplicationFormId(testApplicationForm.getId()));
            return testApplicationForm;
        }
        return null;
    }*/

    /*@Override
    public TestWorkOrder queryTestWorkOrderByTestTradeId(Long testTradeId) {
        List<TestWorkOrder> testWorkOrderList = testWorkOrderMapper.queryTestWorkOrderByTestTradeId(testTradeId);
        if(testWorkOrderList != null && testWorkOrderList.size() != 0){
            TestWorkOrder testWorkOrder = testWorkOrderList.get(0);
            testWorkOrder.setTestWorkOrderItemList(testWorkOrderItemMapper.selectByTestWorkOrderId(testWorkOrder.getId()));
            return testWorkOrder;
        }
        return null;
    }*/

    @Override
    public int insertTestReport(TestReport testReport) {
        return testReportMapper.insert(testReport);
    }

    /*@Override
    public TestReport queryTestReportByTestTradeId(Long testTradeId) {
        List<TestReport> testReportList = testReportMapper.queryTestReportByTestTradeId(testTradeId);
        if(testReportList != null && testReportList.size() != 0){
            TestReport testReport = testReportList.get(0);
            return testReport;
        }
        return null;
    }*/

    @Override
    public int deleteTestQuotationById(Long testQuotationId) {
        return testQuotationMapper.deleteByPrimaryKey(testQuotationId);
    }

    @Override
    public int deleteTestApplyById(Long testApplyId) {
        return testApplicationFormMapper.deleteByPrimaryKey(testApplyId);
    }

    @Override
    public int deleteTestWorkOrderById(Long testWorkOrderId) {
        return testWorkOrderMapper.deleteByPrimaryKey(testWorkOrderId);
    }

    @Override
    public int deleteTestReportById(Long testReportId) {
        return testReportMapper.deleteByPrimaryKey(testReportId);
    }

    @Override
    public TestQuotation selectTestQuotationById(Long id) {
        return testQuotationMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTestQuotationByPrimaryKey(TestQuotation testQuotation) {
        testQuotationMapper.updateByPrimaryKey(testQuotation);
    }

    @Override
    public TestApplicationForm selectTestApplyById(Long id) {
        return testApplicationFormMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTestApplyByPrimaryKey(TestApplicationForm testApply) {
        testApplicationFormMapper.updateByPrimaryKey(testApply);
    }

    @Override
    public TestWorkOrder selectTestWorkOrderById(Long id) {
        return testWorkOrderMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTestWorkOrderByPrimaryKey(TestWorkOrder testWorkOrder) {
        testWorkOrderMapper.updateByPrimaryKey(testWorkOrder);
    }

    @Override
    public TestReport selectTestReportById(Long id) {
        return testReportMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTestReportByPrimaryKey(TestReport testReport) {
        testReportMapper.updateByPrimaryKey(testReport);
    }

    @Override
    public void updateTestQuotationItemByPrimaryKey(TestQuotationItem testQuotationItem) {
        testQuotationItemMapper.updateByPrimaryKey(testQuotationItem);
    }

    @Override
    public void updateTestApplicationItemByPrimaryKey(TestApplicationItem testApplicationItem) {
        testApplicationItemMapper.updateByPrimaryKey(testApplicationItem);
    }

    @Override
    public void updateTestWorkOrderItemByPrimaryKey(TestWorkOrderItem testWorkOrderItem) {
        testWorkOrderItemMapper.updateByPrimaryKey(testWorkOrderItem);
    }

    @Override
    public void deleteTestQuotationItemById(Long id) {
        testQuotationItemMapper.deleteByPrimaryKey(id);
    }

  @Override
  public void deleteTestApplicationItemById(Long id) {
    testApplicationItemMapper.deleteByPrimaryKey(id);
  }

    @Override
    public void deleteTestWorkOrderItemById(Long id) {
        testWorkOrderItemMapper.deleteByPrimaryKey(id);
    }

  /*@Override
  public TestReport selectTestReportByReportNum(String reportNum) {
    return testReportMapper.selectTestReportByReportNum(reportNum);
  }*/
}
