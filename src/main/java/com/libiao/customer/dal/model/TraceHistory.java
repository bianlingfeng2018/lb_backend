package com.libiao.customer.dal.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TraceHistory {
    private Long id;

    private Long clientId;

    private Long traceUserId;

    private String traceUserName;

    private String opType;

    private String opDate;

    private String protectDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getTraceUserId() {
        return traceUserId;
    }

    public void setTraceUserId(Long traceUserId) {
        this.traceUserId = traceUserId;
    }

    public String getTraceUserName() {
        return traceUserName;
    }

    public void setTraceUserName(String traceUserName) {
        this.traceUserName = traceUserName;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getOpDate() {
        return opDate;
    }

    public void setOpDate(String opDate) {
        this.opDate = opDate;
    }

    public String getProtectDate() {
        return protectDate;
    }

    public void setProtectDate(String protectDate) {
        this.protectDate = protectDate;
    }
}