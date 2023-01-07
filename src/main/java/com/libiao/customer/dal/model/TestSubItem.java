package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestSubItem implements Serializable {
    private Long id;

    private String testItem;

    private String subTestItem;

    private String cas;

    private String limitValue;

    private String unit;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTestItem() {
        return testItem;
    }

    public void setTestItem(String testItem) {
        this.testItem = testItem;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", testItem=").append(testItem);
        sb.append(", subTestItem=").append(subTestItem);
        sb.append(", cas=").append(cas);
        sb.append(", limitValue=").append(limitValue);
        sb.append(", unit=").append(unit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}