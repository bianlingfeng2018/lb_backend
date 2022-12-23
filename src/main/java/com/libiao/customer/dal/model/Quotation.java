package com.libiao.customer.dal.model;

import java.util.Date;

public class Quotation {
    private String quotationId;

    private String name;

    private Integer amount;

    private Integer paidAmt;

    private Integer state;

    private Date quoteDate;

    private Long quotePerson;

    private Long customerId;

    public String getQuotationId() {
        return quotationId;
    }

    public void setQuotationId(String quotationId) {
        this.quotationId = quotationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(Integer paidAmt) {
        this.paidAmt = paidAmt;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getQuoteDate() {
        return quoteDate;
    }

    public void setQuoteDate(Date quoteDate) {
        this.quoteDate = quoteDate;
    }

    public Long getQuotePerson() {
        return quotePerson;
    }

    public void setQuotePerson(Long quotePerson) {
        this.quotePerson = quotePerson;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
}