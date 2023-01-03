package com.libiao.customer.dal.model;

import java.io.Serializable;
import java.util.Date;

public class TestQuotation implements Serializable {
    private Long id;

    private Long clientId;

    private String clientNum;

    private String clientName;

    private Long userId;

    private String userOrgNo;

    private Byte state;

    private Byte step;

    private String tradeName;

    private String quotationNum;

    private Byte payStatus;

    private String tradeDesc;

    private Byte payType;

    private String attn;

    private String telClient;

    private String faxClient;

    private String email;

    private Date gmtCreate;

    private String invoiceTitle;

    private String deliveryAddress;

    private String bankAccountName;

    private String bankAccount;

    private String bankName;

    private String clientComSignature;

    private String libiaoRepresentativeSignature;

    private String clientComChop;

    private String audit;

    private String clientSignatureDate;

    private String libiaoSignatureDate;

    private Long testTradeId;

    private String fromCom;

    private String reportFee;

    private String courierFee;

    private String taxFee;

    private String discount;

    private Integer totalCost;

    private Integer totalTestAmt;

    private Integer paidAmt;

    private Long serviceId;

    private Byte type;

    private Byte singleReport;

    private String orgquotationnum;

    private Long auditId;

    private String auditName;

    private String auditReason;

    private String remark;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getClientNum() {
        return clientNum;
    }

    public void setClientNum(String clientNum) {
        this.clientNum = clientNum;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserOrgNo() {
        return userOrgNo;
    }

    public void setUserOrgNo(String userOrgNo) {
        this.userOrgNo = userOrgNo;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public Byte getStep() {
        return step;
    }

    public void setStep(Byte step) {
        this.step = step;
    }

    public String getTradeName() {
        return tradeName;
    }

    public void setTradeName(String tradeName) {
        this.tradeName = tradeName;
    }

    public String getQuotationNum() {
        return quotationNum;
    }

    public void setQuotationNum(String quotationNum) {
        this.quotationNum = quotationNum;
    }

    public Byte getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(Byte payStatus) {
        this.payStatus = payStatus;
    }

    public String getTradeDesc() {
        return tradeDesc;
    }

    public void setTradeDesc(String tradeDesc) {
        this.tradeDesc = tradeDesc;
    }

    public Byte getPayType() {
        return payType;
    }

    public void setPayType(Byte payType) {
        this.payType = payType;
    }

    public String getAttn() {
        return attn;
    }

    public void setAttn(String attn) {
        this.attn = attn;
    }

    public String getTelClient() {
        return telClient;
    }

    public void setTelClient(String telClient) {
        this.telClient = telClient;
    }

    public String getFaxClient() {
        return faxClient;
    }

    public void setFaxClient(String faxClient) {
        this.faxClient = faxClient;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getClientComSignature() {
        return clientComSignature;
    }

    public void setClientComSignature(String clientComSignature) {
        this.clientComSignature = clientComSignature;
    }

    public String getLibiaoRepresentativeSignature() {
        return libiaoRepresentativeSignature;
    }

    public void setLibiaoRepresentativeSignature(String libiaoRepresentativeSignature) {
        this.libiaoRepresentativeSignature = libiaoRepresentativeSignature;
    }

    public String getClientComChop() {
        return clientComChop;
    }

    public void setClientComChop(String clientComChop) {
        this.clientComChop = clientComChop;
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit;
    }

    public String getClientSignatureDate() {
        return clientSignatureDate;
    }

    public void setClientSignatureDate(String clientSignatureDate) {
        this.clientSignatureDate = clientSignatureDate;
    }

    public String getLibiaoSignatureDate() {
        return libiaoSignatureDate;
    }

    public void setLibiaoSignatureDate(String libiaoSignatureDate) {
        this.libiaoSignatureDate = libiaoSignatureDate;
    }

    public Long getTestTradeId() {
        return testTradeId;
    }

    public void setTestTradeId(Long testTradeId) {
        this.testTradeId = testTradeId;
    }

    public String getFromCom() {
        return fromCom;
    }

    public void setFromCom(String fromCom) {
        this.fromCom = fromCom;
    }

    public String getReportFee() {
        return reportFee;
    }

    public void setReportFee(String reportFee) {
        this.reportFee = reportFee;
    }

    public String getCourierFee() {
        return courierFee;
    }

    public void setCourierFee(String courierFee) {
        this.courierFee = courierFee;
    }

    public String getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(String taxFee) {
        this.taxFee = taxFee;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public Integer getTotalTestAmt() {
        return totalTestAmt;
    }

    public void setTotalTestAmt(Integer totalTestAmt) {
        this.totalTestAmt = totalTestAmt;
    }

    public Integer getPaidAmt() {
        return paidAmt;
    }

    public void setPaidAmt(Integer paidAmt) {
        this.paidAmt = paidAmt;
    }

    public Long getServiceId() {
        return serviceId;
    }

    public void setServiceId(Long serviceId) {
        this.serviceId = serviceId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getSingleReport() {
        return singleReport;
    }

    public void setSingleReport(Byte singleReport) {
        this.singleReport = singleReport;
    }

    public String getOrgquotationnum() {
        return orgquotationnum;
    }

    public void setOrgquotationnum(String orgquotationnum) {
        this.orgquotationnum = orgquotationnum;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public String getAuditName() {
        return auditName;
    }

    public void setAuditName(String auditName) {
        this.auditName = auditName;
    }

    public String getAuditReason() {
        return auditReason;
    }

    public void setAuditReason(String auditReason) {
        this.auditReason = auditReason;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", clientId=").append(clientId);
        sb.append(", clientNum=").append(clientNum);
        sb.append(", clientName=").append(clientName);
        sb.append(", userId=").append(userId);
        sb.append(", userOrgNo=").append(userOrgNo);
        sb.append(", state=").append(state);
        sb.append(", step=").append(step);
        sb.append(", tradeName=").append(tradeName);
        sb.append(", quotationNum=").append(quotationNum);
        sb.append(", payStatus=").append(payStatus);
        sb.append(", tradeDesc=").append(tradeDesc);
        sb.append(", payType=").append(payType);
        sb.append(", attn=").append(attn);
        sb.append(", telClient=").append(telClient);
        sb.append(", faxClient=").append(faxClient);
        sb.append(", email=").append(email);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", deliveryAddress=").append(deliveryAddress);
        sb.append(", bankAccountName=").append(bankAccountName);
        sb.append(", bankAccount=").append(bankAccount);
        sb.append(", bankName=").append(bankName);
        sb.append(", clientComSignature=").append(clientComSignature);
        sb.append(", libiaoRepresentativeSignature=").append(libiaoRepresentativeSignature);
        sb.append(", clientComChop=").append(clientComChop);
        sb.append(", audit=").append(audit);
        sb.append(", clientSignatureDate=").append(clientSignatureDate);
        sb.append(", libiaoSignatureDate=").append(libiaoSignatureDate);
        sb.append(", testTradeId=").append(testTradeId);
        sb.append(", fromCom=").append(fromCom);
        sb.append(", reportFee=").append(reportFee);
        sb.append(", courierFee=").append(courierFee);
        sb.append(", taxFee=").append(taxFee);
        sb.append(", discount=").append(discount);
        sb.append(", totalCost=").append(totalCost);
        sb.append(", totalTestAmt=").append(totalTestAmt);
        sb.append(", paidAmt=").append(paidAmt);
        sb.append(", serviceId=").append(serviceId);
        sb.append(", type=").append(type);
        sb.append(", singleReport=").append(singleReport);
        sb.append(", orgquotationnum=").append(orgquotationnum);
        sb.append(", auditId=").append(auditId);
        sb.append(", auditName=").append(auditName);
        sb.append(", auditReason=").append(auditReason);
        sb.append(", remark=").append(remark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}