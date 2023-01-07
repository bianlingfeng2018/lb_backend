package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestWorkOrderItem implements Serializable {
    private Long id;

    private Long testWorkOrderId;

    private String sampleLocation;

    private String sampleModel;

    private String sampleMaterial;

    private String sampleDesc;

    private Integer testItemId;

    private String testItem;

    private String testItemMethod;

    private String testItemCase;

    private Integer labId;

    private String remark;

    private static final long serialVersionUID = 1L;

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

    public String getSampleLocation() {
        return sampleLocation;
    }

    public void setSampleLocation(String sampleLocation) {
        this.sampleLocation = sampleLocation;
    }

    public String getSampleModel() {
        return sampleModel;
    }

    public void setSampleModel(String sampleModel) {
        this.sampleModel = sampleModel;
    }

    public String getSampleMaterial() {
        return sampleMaterial;
    }

    public void setSampleMaterial(String sampleMaterial) {
        this.sampleMaterial = sampleMaterial;
    }

    public String getSampleDesc() {
        return sampleDesc;
    }

    public void setSampleDesc(String sampleDesc) {
        this.sampleDesc = sampleDesc;
    }

    public Integer getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Integer testItemId) {
        this.testItemId = testItemId;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
    }

    public String getTestItemMethod() {
        return testItemMethod;
    }

    public void setTestItemMethod(String testItemMethod) {
        this.testItemMethod = testItemMethod;
    }

    public String getTestItemCase() {
        return testItemCase;
    }

    public void setTestItemCase(String testItemCase) {
        this.testItemCase = testItemCase;
    }

    public Integer getLabId() {
        return labId;
    }

    public void setLabId(Integer labId) {
        this.labId = labId;
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
        sb.append(", testWorkOrderId=").append(testWorkOrderId);
        sb.append(", sampleLocation=").append(sampleLocation);
        sb.append(", sampleModel=").append(sampleModel);
        sb.append(", sampleMaterial=").append(sampleMaterial);
        sb.append(", sampleDesc=").append(sampleDesc);
        sb.append(", testItemId=").append(testItemId);
        sb.append(", testItem=").append(testItem);
        sb.append(", testItemMethod=").append(testItemMethod);
        sb.append(", testItemCase=").append(testItemCase);
        sb.append(", labId=").append(labId);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}