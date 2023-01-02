package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class ClientContract implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.client_id
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private Long clientId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.client_num
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private String clientNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.client_name
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private String clientName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.contract_start_date
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private Date contractStartDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.contract_end_date
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private Date contractEndDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.contract_status
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private Byte contractStatus;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.settle_period
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private Integer settlePeriod;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.type
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private Byte type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column client_contract.contract_path
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private String contractPath;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table client_contract
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.client_id
     *
     * @return the value of client_contract.client_id
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public Long getClientId() {
        return clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.client_id
     *
     * @param clientId the value for client_contract.client_id
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.client_num
     *
     * @return the value of client_contract.client_num
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public String getClientNum() {
        return clientNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.client_num
     *
     * @param clientNum the value for client_contract.client_num
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.client_name
     *
     * @return the value of client_contract.client_name
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public String getClientName() {
        return clientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.client_name
     *
     * @param clientName the value for client_contract.client_name
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.contract_start_date
     *
     * @return the value of client_contract.contract_start_date
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public Date getContractStartDate() {
        return contractStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.contract_start_date
     *
     * @param contractStartDate the value for client_contract.contract_start_date
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.contract_end_date
     *
     * @return the value of client_contract.contract_end_date
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public Date getContractEndDate() {
        return contractEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.contract_end_date
     *
     * @param contractEndDate the value for client_contract.contract_end_date
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.contract_status
     *
     * @return the value of client_contract.contract_status
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public Byte getContractStatus() {
        return contractStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.contract_status
     *
     * @param contractStatus the value for client_contract.contract_status
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setContractStatus(Byte contractStatus) {
        this.contractStatus = contractStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.settle_period
     *
     * @return the value of client_contract.settle_period
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public Integer getSettlePeriod() {
        return settlePeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.settle_period
     *
     * @param settlePeriod the value for client_contract.settle_period
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setSettlePeriod(Integer settlePeriod) {
        this.settlePeriod = settlePeriod;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.type
     *
     * @return the value of client_contract.type
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public Byte getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.type
     *
     * @param type the value for client_contract.type
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column client_contract.contract_path
     *
     * @return the value of client_contract.contract_path
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public String getContractPath() {
        return contractPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column client_contract.contract_path
     *
     * @param contractPath the value for client_contract.contract_path
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    public void setContractPath(String contractPath) {
        this.contractPath = contractPath;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table client_contract
     *
     * @mbg.generated Mon Jan 02 11:25:59 CST 2023
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", clientId=").append(clientId);
        sb.append(", clientNum=").append(clientNum);
        sb.append(", clientName=").append(clientName);
        sb.append(", contractStartDate=").append(contractStartDate);
        sb.append(", contractEndDate=").append(contractEndDate);
        sb.append(", contractStatus=").append(contractStatus);
        sb.append(", settlePeriod=").append(settlePeriod);
        sb.append(", type=").append(type);
        sb.append(", contractPath=").append(contractPath);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}