package com.libiao.customer.dal.model;

public class TestApplicationItem {
    private Long id;

    private Long testApplicationFormId; // 申请表id

    private String sampleName; // 样本名称

    private String sampleModel; // 样品型号

    private String sampleMaterial; // 材质

    private String sampleDescription; // 样品描述

    private String testingItem; // 测试项目

    private String accordingTo; // 判定依据

    private String remark; // 备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestApplicationFormId() {
        return testApplicationFormId;
    }

    public void setTestApplicationFormId(Long testApplicationFormId) {
        this.testApplicationFormId = testApplicationFormId;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
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

    public String getSampleDescription() {
        return sampleDescription;
    }

    public void setSampleDescription(String sampleDescription) {
        this.sampleDescription = sampleDescription;
    }

    public String getTestingItem() {
        return testingItem;
    }

    public void setTestingItem(String testingItem) {
        this.testingItem = testingItem;
    }

    public String getAccordingTo() {
        return accordingTo;
    }

    public void setAccordingTo(String accordingTo) {
        this.accordingTo = accordingTo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remard) {
        this.remark = remard;
    }
}