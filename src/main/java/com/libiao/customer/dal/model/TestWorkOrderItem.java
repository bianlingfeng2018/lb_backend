package com.libiao.customer.dal.model;

public class TestWorkOrderItem {
    private Long id;

    private Long testWorkOrderId;

    private String sampleDesc;

    private String sampleLocation;

    private String testItemsMethod;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestWorkOrderId() {
        return testWorkOrderId;
    }

    public void setTestWorkOrderId(Long testWorkOrderId) {
        this.testWorkOrderId = testWorkOrderId;
    }

    public String getSampleDesc() {
        return sampleDesc;
    }

    public void setSampleDesc(String sampleDesc) {
        this.sampleDesc = sampleDesc;
    }

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getTestItemsMethod() {
        return testItemsMethod;
    }

    public void setTestItemsMethod(String testItemsMethod) {
        this.testItemsMethod = testItemsMethod;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}