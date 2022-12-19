package com.libiao.customer.dal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestReport {
    private Long id;

    private String reportNum;

    private String sampleName;

    private String client;

    private String address;

    private String sampleModel;

    private String brand;

    private String supplier;

    private String orderNum;

    private String buyer;

    private String producers;

    private String exportPlace;

    private String producingCountry;

    private String testTradeId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date receivingDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date testStartDate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date testEndDate;

    private String approver;

    private String reviewer;

    private String editor;

    private String sampleDesc;

    private String testExperiment;

    private String testRemark;

    private String remark;

    private String testPeriod;

    private String flexObj;

    public String getSampleDesc() {
        return sampleDesc;
    }

    public void setSampleDesc(String sampleDesc) {
        this.sampleDesc = sampleDesc;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSampleModel() {
        return sampleModel;
    }

    public void setSampleModel(String sampleModel) {
        this.sampleModel = sampleModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getProducers() {
        return producers;
    }

    public void setProducers(String producers) {
        this.producers = producers;
    }

    public String getExportPlace() {
        return exportPlace;
    }

    public void setExportPlace(String exportPlace) {
        this.exportPlace = exportPlace;
    }

    public String getProducingCountry() {
        return producingCountry;
    }

    public void setProducingCountry(String producingCountry) {
        this.producingCountry = producingCountry;
    }

    public String getTestTradeId() {
        return testTradeId;
    }

    public void setTestTradeId(String testTradeId) {
        this.testTradeId = testTradeId;
    }

    public Date getReceivingDate() {
        return receivingDate;
    }

    public void setReceivingDate(Date receivingDate) {
        this.receivingDate = receivingDate;
    }

    public Date getTestStartDate() {
        return testStartDate;
    }

    public void setTestStartDate(Date testStartDate) {
        this.testStartDate = testStartDate;
    }

    public Date getTestEndDate() {
        return testEndDate;
    }

    public void setTestEndDate(Date testEndDate) {
        this.testEndDate = testEndDate;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getTestExperiment() {
        return testExperiment;
    }

    public void setTestExperiment(String testExperiment) {
        this.testExperiment = testExperiment;
    }

    public String getTestRemark() {
        return testRemark;
    }

    public void setTestRemark(String testRemark) {
        this.testRemark = testRemark;
    }
}