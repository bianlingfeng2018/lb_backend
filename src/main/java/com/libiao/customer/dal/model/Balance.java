package com.libiao.customer.dal.model;

public class Balance {
    private Long id;

    private String clientId;

    private Long unsettledAmt;

    private Long balanceAmt;

    private Long creditLimit;

    private Long commissionRate;

    private Long unsettleCommission;

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

    public Long getCommissionRate() {
        return commissionRate;
    }

    public void setCommissionRate(Long commissionRate) {
        this.commissionRate = commissionRate;
    }

    public Long getUnsettleCommission() {
        return unsettleCommission;
    }

    public void setUnsettleCommission(Long unsettleCommission) {
        this.unsettleCommission = unsettleCommission;
    }
}