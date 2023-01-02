package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class CustomerBill implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.trade_id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private String tradeId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.client_id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private String clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.order_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Integer orderAmt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.income_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Integer incomeAmt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.bill_path
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private String billPath;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.upload_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Date uploadTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.income_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Date incomeTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.oper_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Date operTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.status
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Byte status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.oper_user
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private String operUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column customer_bill.settle_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private Integer settleAmt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table customer_bill
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.id
     *
     * @return the value of customer_bill.id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.id
     *
     * @param id the value for customer_bill.id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.trade_id
     *
     * @return the value of customer_bill.trade_id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public String getTradeId() {
        return tradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.trade_id
     *
     * @param tradeId the value for customer_bill.trade_id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.client_id
     *
     * @return the value of customer_bill.client_id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.client_id
     *
     * @param clientId the value for customer_bill.client_id
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.order_amt
     *
     * @return the value of customer_bill.order_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Integer getOrderAmt() {
        return orderAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.order_amt
     *
     * @param orderAmt the value for customer_bill.order_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setOrderAmt(Integer orderAmt) {
        this.orderAmt = orderAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.income_amt
     *
     * @return the value of customer_bill.income_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Integer getIncomeAmt() {
        return incomeAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.income_amt
     *
     * @param incomeAmt the value for customer_bill.income_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setIncomeAmt(Integer incomeAmt) {
        this.incomeAmt = incomeAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.bill_path
     *
     * @return the value of customer_bill.bill_path
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public String getBillPath() {
        return billPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.bill_path
     *
     * @param billPath the value for customer_bill.bill_path
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setBillPath(String billPath) {
        this.billPath = billPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.upload_time
     *
     * @return the value of customer_bill.upload_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Date getUploadTime() {
        return uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.upload_time
     *
     * @param uploadTime the value for customer_bill.upload_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.income_time
     *
     * @return the value of customer_bill.income_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Date getIncomeTime() {
        return incomeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.income_time
     *
     * @param incomeTime the value for customer_bill.income_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setIncomeTime(Date incomeTime) {
        this.incomeTime = incomeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.oper_time
     *
     * @return the value of customer_bill.oper_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Date getOperTime() {
        return operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.oper_time
     *
     * @param operTime the value for customer_bill.oper_time
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setOperTime(Date operTime) {
        this.operTime = operTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.status
     *
     * @return the value of customer_bill.status
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.status
     *
     * @param status the value for customer_bill.status
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.oper_user
     *
     * @return the value of customer_bill.oper_user
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public String getOperUser() {
        return operUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.oper_user
     *
     * @param operUser the value for customer_bill.oper_user
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column customer_bill.settle_amt
     *
     * @return the value of customer_bill.settle_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public Integer getSettleAmt() {
        return settleAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column customer_bill.settle_amt
     *
     * @param settleAmt the value for customer_bill.settle_amt
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    public void setSettleAmt(Integer settleAmt) {
        this.settleAmt = settleAmt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table customer_bill
     *
     * @mbg.generated Mon Jan 02 14:51:18 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", tradeId=").append(tradeId);
        sb.append(", clientId=").append(clientId);
        sb.append(", orderAmt=").append(orderAmt);
        sb.append(", incomeAmt=").append(incomeAmt);
        sb.append(", billPath=").append(billPath);
        sb.append(", uploadTime=").append(uploadTime);
        sb.append(", incomeTime=").append(incomeTime);
        sb.append(", operTime=").append(operTime);
        sb.append(", status=").append(status);
        sb.append(", operUser=").append(operUser);
        sb.append(", settleAmt=").append(settleAmt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}