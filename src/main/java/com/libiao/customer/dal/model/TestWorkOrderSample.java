package com.libiao.customer.dal.model;

import java.io.Serializable;

public class TestWorkOrderSample implements Serializable {
    private Long id;

    private Long testWorkOrderId;

    private String fileName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTestWorkOrderId() {
        return testWorkOrderId;
    }

    public void setTestWorkOrderId(Long testWorkOrderId) {
        this.testWorkOrderId = testWorkOrderId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", testWorkOrderId=").append(testWorkOrderId);
        sb.append(", fileName=").append(fileName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}