package com.libiao.customer.dal.model;

import java.util.Date;

public class Balance {
    private Long id;

    private String clientId;

    private Long unsettledAmt;

    private Long balanceAmt;

    private Long creditLimit;

    private Long unsettleCommission;

    private Date createTime;

    private Date changeTime;

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

    public Long getUnsettledAmt() {
        return unsettledAmt;
    }

    public void setUnsettledAmt(Long unsettledAmt) {
        this.unsettledAmt = unsettledAmt;
    }

    public Long getBalanceAmt() {
        return balanceAmt;
    }

    public void setBalanceAmt(Long balanceAmt) {
        this.balanceAmt = balanceAmt;
    }

    public Long getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(Long creditLimit) {
        this.creditLimit = creditLimit;
    }

    public Long getUnsettleCommission() {
        return unsettleCommission;
    }

    public void setUnsettleCommission(Long unsettleCommission) {
        this.unsettleCommission = unsettleCommission;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getChangeTime() {
        return changeTime;
    }

    public void setChangeTime(Date changeTime) {
        this.changeTime = changeTime;
    }
}