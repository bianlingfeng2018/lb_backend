package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestRecordSubItem implements Serializable {
    private Long oriRecordId;

    private String subTestItem;

    private String cas;

    private String limitValue;

    private String unit;

    private String avgValue;

    private String testResult;

    private static final long serialVersionUID = 1L;

    public Long getOriRecordId() {
        return oriRecordId;
    }

    public void setOriRecordId(Long oriRecordId) {
        this.oriRecordId = oriRecordId;
    }

    public String getSubTestItem() {
        return subTestItem;
    }

    public void setSubTestItem(String subTestItem) {
        this.subTestItem = subTestItem;
    }

    public String getCas() {
        return cas;
    }

    public void setCas(String cas) {
        this.cas = cas;
    }

    public String getLimitValue() {
        return limitValue;
    }

    public void setLimitValue(String limitValue) {
        this.limitValue = limitValue;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAvgValue() {
        return avgValue;
    }

    public void setAvgValue(String avgValue) {
        this.avgValue = avgValue;
    }

    public String getTestResult() {
        return testResult;
    }

    public void setTestResult(String testResult) {
        this.testResult = testResult;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oriRecordId=").append(oriRecordId);
        sb.append(", subTestItem=").append(subTestItem);
        sb.append(", cas=").append(cas);
        sb.append(", limitValue=").append(limitValue);
        sb.append(", unit=").append(unit);
        sb.append(", avgValue=").append(avgValue);
        sb.append(", testResult=").append(testResult);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}