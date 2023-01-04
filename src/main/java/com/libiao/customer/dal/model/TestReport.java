package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class TestReport implements Serializable {
    private Long id;

    private String quotationNum;

    private String applicationNum;

    private String reportNum;

    private Date reportDate;

    private String planDate;

    private String client;

    private String approver;

    private String reviewer;

    private String editor;

    private String charger;

    private String tester;

    private Byte reportStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuotationNum() {
        return quotationNum;
    }

    public void setQuotationNum(String quotationNum) {
        this.quotationNum = quotationNum;
    }

    public String getApplicationNum() {
        return applicationNum;
    }

    public void setApplicationNum(String applicationNum) {
        this.applicationNum = applicationNum;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public String getPlanDate() {
        return planDate;
    }

    public void setPlanDate(String planDate) {
        this.planDate = planDate;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public String getTester() {
        return tester;
    }

    public void setTester(String tester) {
        this.tester = tester;
    }

    public Byte getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(Byte reportStatus) {
        this.reportStatus = reportStatus;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", quotationNum=").append(quotationNum);
        sb.append(", applicationNum=").append(applicationNum);
        sb.append(", reportNum=").append(reportNum);
        sb.append(", reportDate=").append(reportDate);
        sb.append(", planDate=").append(planDate);
        sb.append(", client=").append(client);
        sb.append(", approver=").append(approver);
        sb.append(", reviewer=").append(reviewer);
        sb.append(", editor=").append(editor);
        sb.append(", charger=").append(charger);
        sb.append(", tester=").append(tester);
        sb.append(", reportStatus=").append(reportStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}