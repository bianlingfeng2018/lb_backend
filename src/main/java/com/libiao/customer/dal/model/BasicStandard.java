package com.libiao.customer.dal.model;

import java.io.Serializable;

public class BasicStandard implements Serializable {
    private Integer id;

    private String name;

    private String method;

    private String item;

    private Integer testItemId;

    private Byte type;

    private String value;

    private String minValue;

    private Byte containMin;

    private String maxValue;

    private Byte containMax;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getTestItemId() {
        return testItemId;
    }

    public void setTestItemId(Integer testItemId) {
        this.testItemId = testItemId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMinValue() {
        return minValue;
    }

    public void setMinValue(String minValue) {
        this.minValue = minValue;
    }

    public Byte getContainMin() {
        return containMin;
    }

    public void setContainMin(Byte containMin) {
        this.containMin = containMin;
    }

    public String getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(String maxValue) {
        this.maxValue = maxValue;
    }

    public Byte getContainMax() {
        return containMax;
    }

    public void setContainMax(Byte containMax) {
        this.containMax = containMax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", method=").append(method);
        sb.append(", item=").append(item);
        sb.append(", testItemId=").append(testItemId);
        sb.append(", type=").append(type);
        sb.append(", value=").append(value);
        sb.append(", minValue=").append(minValue);
        sb.append(", containMin=").append(containMin);
        sb.append(", maxValue=").append(maxValue);
        sb.append(", containMax=").append(containMax);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}