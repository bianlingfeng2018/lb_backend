package com.libiao.customer.dal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestWorkOrder {
    private Long id;

    private String workOrderNum;

    private String issuer;

    private String busyStatus;

    private Long testTradeId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtOutput;

    private String withdraw;

    private String employee;

    private String customer;

    /**
     * 指定的测试人员Id
     */
    private Long testId;

    private List<TestWorkOrderItem> testWorkOrderItemList;
    private Long reviewerId;
    private Long approverId;
    private Long editorId;

    private String flexObj;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWorkOrderNum() {
        return workOrderNum;
    }

    public void setWorkOrderNum(String workOrderNum) {
        this.workOrderNum = workOrderNum;
    }

    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }

    public String getBusyStatus() {
        return busyStatus;
    }

    public void setBusyStatus(String busyStatus) {
        this.busyStatus = busyStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtOutput() {
        return gmtOutput;
    }

    public void setGmtOutput(Date gmtOutput) {
        this.gmtOutput = gmtOutput;
    }

    public String getWithdraw() {
        return withdraw;
    }

    public void setWithdraw(String withdraw) {
        this.withdraw = withdraw;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }


    public List<TestWorkOrderItem> getTestWorkOrderItemList() {
        return testWorkOrderItemList;
    }

    public void setTestWorkOrderItemList(List<TestWorkOrderItem> testWorkOrderItemList) {
        this.testWorkOrderItemList = testWorkOrderItemList;
    }

    public Long getTestTradeId(){
        return testTradeId;
    }

    public void setTestTradeId(Long testTradeId){
        this.testTradeId = testTradeId;
    }

  public Long getReviewerId() {
    return reviewerId;
  }

  public void setReviewerId(Long reviewerId) {
    this.reviewerId = reviewerId;
  }

    public Long getApproverId() {
        return approverId;
    }

    public void setApproverId(Long approverId) {
        this.approverId = approverId;
    }

  public Long getEditorId() {
    return editorId;
  }

  public void setEditorId(Long editorId) {
    this.editorId = editorId;
  }
}