package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class ClientBillIncome implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.id
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.client_id
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private String clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.opration_type
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private String oprationType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.origin_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private Long originAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.operation_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private Long operationAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.final_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private Long finalAmount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.operation_time
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private Date operationTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.oper_user
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private String operUser;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.descp
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private String descp;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_bill_income.income_comp
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private String incomeComp;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table client_bill_income
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.id
     *
     * @return the value of client_bill_income.id
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.id
     *
     * @param id the value for client_bill_income.id
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.client_id
     *
     * @return the value of client_bill_income.client_id
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public String getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.client_id
     *
     * @param clientId the value for client_bill_income.client_id
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.opration_type
     *
     * @return the value of client_bill_income.opration_type
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public String getOprationType() {
        return oprationType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.opration_type
     *
     * @param oprationType the value for client_bill_income.opration_type
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setOprationType(String oprationType) {
        this.oprationType = oprationType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.origin_amount
     *
     * @return the value of client_bill_income.origin_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public Long getOriginAmount() {
        return originAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.origin_amount
     *
     * @param originAmount the value for client_bill_income.origin_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setOriginAmount(Long originAmount) {
        this.originAmount = originAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.operation_amount
     *
     * @return the value of client_bill_income.operation_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public Long getOperationAmount() {
        return operationAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.operation_amount
     *
     * @param operationAmount the value for client_bill_income.operation_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setOperationAmount(Long operationAmount) {
        this.operationAmount = operationAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.final_amount
     *
     * @return the value of client_bill_income.final_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public Long getFinalAmount() {
        return finalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.final_amount
     *
     * @param finalAmount the value for client_bill_income.final_amount
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setFinalAmount(Long finalAmount) {
        this.finalAmount = finalAmount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.operation_time
     *
     * @return the value of client_bill_income.operation_time
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public Date getOperationTime() {
        return operationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.operation_time
     *
     * @param operationTime the value for client_bill_income.operation_time
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setOperationTime(Date operationTime) {
        this.operationTime = operationTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.oper_user
     *
     * @return the value of client_bill_income.oper_user
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public String getOperUser() {
        return operUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.oper_user
     *
     * @param operUser the value for client_bill_income.oper_user
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setOperUser(String operUser) {
        this.operUser = operUser;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.descp
     *
     * @return the value of client_bill_income.descp
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public String getDescp() {
        return descp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.descp
     *
     * @param descp the value for client_bill_income.descp
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setDescp(String descp) {
        this.descp = descp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_bill_income.income_comp
     *
     * @return the value of client_bill_income.income_comp
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public String getIncomeComp() {
        return incomeComp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_bill_income.income_comp
     *
     * @param incomeComp the value for client_bill_income.income_comp
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    public void setIncomeComp(String incomeComp) {
        this.incomeComp = incomeComp;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_bill_income
     *
     * @mbg.generated Sun Jan 01 18:06:57 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", oprationType=").append(oprationType);
        sb.append(", originAmount=").append(originAmount);
        sb.append(", operationAmount=").append(operationAmount);
        sb.append(", finalAmount=").append(finalAmount);
        sb.append(", operationTime=").append(operationTime);
        sb.append(", operUser=").append(operUser);
        sb.append(", descp=").append(descp);
        sb.append(", incomeComp=").append(incomeComp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}