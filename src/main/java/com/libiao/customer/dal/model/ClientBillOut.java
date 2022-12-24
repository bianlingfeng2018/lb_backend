package com.libiao.customer.dal.model;

import java.util.Date;

public class ClientBillOut {
    private Long id;

    private String clientId;

    private String tradeId;

    private Long onaccountAmt;

    private Long unAmt;

    private Date startTime;

    private Date lastTime;

    private Date operTime;

    private String status;

    private String operUser;

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

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public Long getOnaccountAmt() {
        return onaccountAmt;
    }

    public void setOnaccountAmt(Long onaccountAmt) {
        this.onaccountAmt = onaccountAmt;
    }

    public Long getUnAmt() {
        return unAmt;
    }

    public void setUnAmt(Long unAmt) {
        this.unAmt = unAmt;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Date getOperTime() {
        return operTime;
    }

    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperUser() {
        return operUser;
    }

    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }
}