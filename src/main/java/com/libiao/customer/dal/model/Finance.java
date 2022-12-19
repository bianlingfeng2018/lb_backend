package com.libiao.customer.dal.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Finance {
    private Long id;

    private String proNum;

    private String proDate;

    private String price;

    private String deal;

    private String pay;

    private String income;

    private String serviceConfirm;

    private String financeConfirm;

    private String type;

    private String client;

    private String discount;

    private String applyDate;

    private String reportDate;

    private String verifyDate;

    private String coefficient;

    private Long tradeId;
    private String reportNum;

    private String agreeToSubcontract;

     private String subcontractPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProNum() {
        return proNum;
    }

    public void setProNum(String proNum) {
        this.proNum = proNum;
    }

    public String getProDate() {
        return proDate;
    }

    public void setProDate(String proDate) {
        this.proDate = proDate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getIncome() {
        return income;
    }

    public void setIncome(String income) {
        this.income = income;
    }

    public String getServiceConfirm() {
        return serviceConfirm;
    }

    public void setServiceConfirm(String serviceConfirm) {
        this.serviceConfirm = serviceConfirm;
    }

    public String getFinanceConfirm() {
        return financeConfirm;
    }

    public void setFinanceConfirm(String financeConfirm) {
        this.financeConfirm = financeConfirm;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(String applyDate) {
        this.applyDate = applyDate;
    }

    public String getReportDate() {
        return reportDate;
    }

    public void setReportDate(String reportDate) {
        this.reportDate = reportDate;
    }

    public String getVerifyDate() {
        return verifyDate;
    }

    public void setVerifyDate(String verifyDate) {
        this.verifyDate = verifyDate;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public Long getTradeId() {
        return tradeId;
    }

    public void setTradeId(Long tradeId) {
        this.tradeId = tradeId;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getReportNum() {
        return reportNum;
    }
}