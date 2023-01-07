package com.libiao.customer.dal.model;

import java.io.Serializable;

public class BasicStandardLevel implements Serializable {
    private Long id;

    private Integer standardId;

    private String levelName;

    private String minValue;

    private Byte containMin;

    private String maxValue;

    private Byte containMax;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getStandardId() {
        return standardId;
    }

    public void setStandardId(Integer standardId) {
        this.standardId = standardId;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
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
        sb.append(", standardId=").append(standardId);
        sb.append(", levelName=").append(levelName);
        sb.append(", minValue=").append(minValue);
        sb.append(", containMin=").append(containMin);
        sb.append(", maxValue=").append(maxValue);
        sb.append(", containMax=").append(containMax);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}