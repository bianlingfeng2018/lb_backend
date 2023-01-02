package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class TestWorkOrder implements Serializable {
    private Long id;

    private String workOrderNum;

    private String quotationNum;

    private String applicationNum;

    private Date createTime;

    private Date orderDate;

    private Date outputDate;

    private Date planDate;

    private Byte service;

    private Integer testComId;

    private String comName;

    private Byte subContract;

    private Byte status;

    private String clientName;

    private String createName;

    private Byte sampleStatus;

    private Long confirmId;

    private static final long serialVersionUID = 1L;

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

    public String getQuotationNum() {
        return quotationNum;
    }

    public void setQuotationNum(String quotationNum) {
        this.quotationNum = quotationNum;
    }

    public String getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(String applicationNum) {
        this.applicationNum = applicationNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getOutputDate() {
        return outputDate;
    }

    public void setOutputDate(Date outputDate) {
        this.outputDate = outputDate;
    }

    public Date getPlanDate() {
        return planDate;
    }

    public void setPlanDate(Date planDate) {
        this.planDate = planDate;
    }

    public Byte getService() {
        return service;
    }

    public void setService(Byte service) {
        this.service = service;
    }

    public Integer getTestComId() {
        return testComId;
    }

    public void setTestComId(Integer testComId) {
        this.testComId = testComId;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public Byte getSubContract() {
        return subContract;
    }

    public void setSubContract(Byte subContract) {
        this.subContract = subContract;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }

    public Byte getSampleStatus() {
        return sampleStatus;
    }

    public void setSampleStatus(Byte sampleStatus) {
        this.sampleStatus = sampleStatus;
    }

    public Long getConfirmId() {
        return confirmId;
    }

    public void setConfirmId(Long confirmId) {
        this.confirmId = confirmId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", workOrderNum=").append(workOrderNum);
        sb.append(", quotationNum=").append(quotationNum);
        sb.append(", applicationNum=").append(applicationNum);
        sb.append(", createTime=").append(createTime);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", outputDate=").append(outputDate);
        sb.append(", planDate=").append(planDate);
        sb.append(", service=").append(service);
        sb.append(", testComId=").append(testComId);
        sb.append(", comName=").append(comName);
        sb.append(", subContract=").append(subContract);
        sb.append(", status=").append(status);
        sb.append(", clientName=").append(clientName);
        sb.append(", createName=").append(createName);
        sb.append(", sampleStatus=").append(sampleStatus);
        sb.append(", confirmId=").append(confirmId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}