package com.libiao.customer.dal.model;

import java.util.Date;

public class ClientBillIncome {
    private Long id;

    private String clientId;

    private String oprationType;

    private Long originAmount;

    private Long operationAmount;

    private Long finalAmount;

    private Date operationTime;

    private String operUser;

    private String desc;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getOprationType() {
        return oprationType;
    }

    public void setOprationType(String oprationType) {
        this.oprationType = oprationType;
    }

    public Long getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(Long originAmount) {
        this.originAmount = originAmount;
    }

    public Long getOperationAmount() {
        return operationAmount;
    }

    public void setOperationAmount(Long operationAmount) {
        this.operationAmount = operationAmount;
    }

    public Long getFinalAmount() {
        return finalAmount;
    }

    public void setFinalAmount(Long finalAmount) {
        this.finalAmount = finalAmount;
    }

    public Date getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}