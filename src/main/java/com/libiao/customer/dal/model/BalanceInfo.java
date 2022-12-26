package com.libiao.customer.dal.model;

import java.util.Date;

public class BalanceInfo {
    private Long id;

    private String clientId;

    private String operUser;

    private Date operTime;

    private Long operAmt;

    private String descp;

    private String operType;

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

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public Long getOperAmt() {
        return operAmt;
    }

    public void setOperAmt(Long operAmt) {
        this.operAmt = operAmt;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }
}