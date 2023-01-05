package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestApplicationItem implements Serializable {
    private Long id;

    private Long appSampleId;

    private String applicationNum;

    private Integer testItemId;

    private String itemName;

    private String testMethod;

    private String testCase;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAppSampleId() {
        return appSampleId;
    }

    public void setAppSampleId(Long appSampleId) {
        this.appSampleId = appSampleId;
    }

    public String getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(String applicationNum) {
        this.applicationNum = applicationNum;
    }

    public Integer getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Integer testItemId) {
        this.testItemId = testItemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appSampleId=").append(appSampleId);
        sb.append(", applicationNum=").append(applicationNum);
        sb.append(", testItemId=").append(testItemId);
        sb.append(", itemName=").append(itemName);
        sb.append(", testMethod=").append(testMethod);
        sb.append(", testCase=").append(testCase);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}