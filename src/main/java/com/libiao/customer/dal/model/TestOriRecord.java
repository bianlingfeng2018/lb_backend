package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class TestOriRecord implements Serializable {
    private Long id;

    private String recordNum;

    private String workOrderNum;

    private String applicationNum;

    private String quotationNum;

    private String reportNum;

    private String testCom;

    private Integer testComId;

    private String testLab;

    private Integer testLabId;

    private String testItem;

    private Integer testItemId;

    private String testDeviceNo;

    private String testDeviceName;

    private String testPersonId;

    private String testPerson;

    private String testMethod;

    private String testCase;

    private Date createTime;

    private Date planDate;

    private Date reportDate;

    private String reportPerson;

    private Long reportPersonId;

    private Byte status;

    private String testValue;

    private String testResult;

    private String testLevel;

    private String oriReportFile;

    private String remark;

    private Date sampleDate;

    private Long reviewId;

    private String reviewName;

    private String reviewReason;

    private Date reviewTime;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecordNum() {
        return recordNum;
    }

    public void setRecordNum(String recordNum) {
        this.recordNum = recordNum;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(String applicationNum) {
        this.applicationNum = applicationNum;
    }

    public String getQuotationNum() {
        return quotationNum;
    }

    public void setQuotationNum(String quotationNum) {
        this.quotationNum = quotationNum;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getTestCom() {
        return testCom;
    }

    public void setTestCom(String testCom) {
        this.testCom = testCom;
    }

    public Integer getTestComId() {
        return testComId;
    }

    public void setTestComId(Integer testComId) {
        this.testComId = testComId;
    }

    public String getTestLab() {
        return testLab;
    }

    public void setTestLab(String testLab) {
        this.testLab = testLab;
    }

    public Integer getTestLabId() {
        return testLabId;
    }

    public void setTestLabId(Integer testLabId) {
        this.testLabId = testLabId;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public Integer getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Integer testItemId) {
        this.testItemId = testItemId;
    }

    public String getTestDeviceNo() {
        return testDeviceNo;
    }

    public void setTestDeviceNo(String testDeviceNo) {
        this.testDeviceNo = testDeviceNo;
    }

    public String getTestDeviceName() {
        return testDeviceName;
    }

    public void setTestDeviceName(String testDeviceName) {
        this.testDeviceName = testDeviceName;
    }

    public String getTestPersonId() {
        return testPersonId;
    }

    public void setTestPersonId(String testPersonId) {
        this.testPersonId = testPersonId;
    }

    public String getTestPerson() {
        return testPerson;
    }

    public void setTestPerson(String testPerson) {
        this.testPerson = testPerson;
    }

    public String getTestMethod() {
        return testMethod;
    }

    public void setTestMethod(String testMethod) {
        this.testMethod = testMethod;
    }

    public String getTestCase() {
        return testCase;
    }

    public void setTestCase(String testCase) {
        this.testCase = testCase;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getReportPerson() {
        return reportPerson;
    }

    public void setReportPerson(String reportPerson) {
        this.reportPerson = reportPerson;
    }

    public Long getReportPersonId() {
        return reportPersonId;
    }

    public void setReportPersonId(Long reportPersonId) {
        this.reportPersonId = reportPersonId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    public String getTestLevel() {
        return testLevel;
    }

    public void setTestLevel(String testLevel) {
        this.testLevel = testLevel;
    }

    public String getOriReportFile() {
        return oriReportFile;
    }

    public void setOriReportFile(String oriReportFile) {
        this.oriReportFile = oriReportFile;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getSampleDate() {
        return sampleDate;
    }

    public void setSampleDate(Date sampleDate) {
        this.sampleDate = sampleDate;
    }

    public Long getReviewId() {
        return reviewId;
    }

    public void setReviewId(Long reviewId) {
        this.reviewId = reviewId;
    }

    public String getReviewName() {
        return reviewName;
    }

    public void setReviewName(String reviewName) {
        this.reviewName = reviewName;
    }

    public String getReviewReason() {
        return reviewReason;
    }

    public void setReviewReason(String reviewReason) {
        this.reviewReason = reviewReason;
    }

    public Date getReviewTime() {
        return reviewTime;
    }

    public void setReviewTime(Date reviewTime) {
        this.reviewTime = reviewTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", recordNum=").append(recordNum);
        sb.append(", workOrderNum=").append(workOrderNum);
        sb.append(", applicationNum=").append(applicationNum);
        sb.append(", quotationNum=").append(quotationNum);
        sb.append(", reportNum=").append(reportNum);
        sb.append(", testCom=").append(testCom);
        sb.append(", testComId=").append(testComId);
        sb.append(", testLab=").append(testLab);
        sb.append(", testLabId=").append(testLabId);
        sb.append(", testItem=").append(testItem);
        sb.append(", testItemId=").append(testItemId);
        sb.append(", testDeviceNo=").append(testDeviceNo);
        sb.append(", testDeviceName=").append(testDeviceName);
        sb.append(", testPersonId=").append(testPersonId);
        sb.append(", testPerson=").append(testPerson);
        sb.append(", testMethod=").append(testMethod);
        sb.append(", testCase=").append(testCase);
        sb.append(", createTime=").append(createTime);
        sb.append(", planDate=").append(planDate);
        sb.append(", reportDate=").append(reportDate);
        sb.append(", reportPerson=").append(reportPerson);
        sb.append(", reportPersonId=").append(reportPersonId);
        sb.append(", status=").append(status);
        sb.append(", testValue=").append(testValue);
        sb.append(", testResult=").append(testResult);
        sb.append(", testLevel=").append(testLevel);
        sb.append(", oriReportFile=").append(oriReportFile);
        sb.append(", remark=").append(remark);
        sb.append(", sampleDate=").append(sampleDate);
        sb.append(", reviewId=").append(reviewId);
        sb.append(", reviewName=").append(reviewName);
        sb.append(", reviewReason=").append(reviewReason);
        sb.append(", reviewTime=").append(reviewTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}