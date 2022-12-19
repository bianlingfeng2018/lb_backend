package com.libiao.customer.dal.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestQuotation {
    private Long id; // 报价单id

    private String client; // 客户

    private String quotationNum; // 报价单编号

    private String attn; // 联络人

    private String fromCom; // 公司from

    private String telClient; // 客户电话

    private String telCom; // 公司电话

    private String faxClient; // 客户传真

    private String faxCom; // 公司传真

    private String email; // 电子邮件

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date gmtCreate; // 报价日期

    private String invoiceTitle; // 发票抬头

    private String reportType; // 报告类型

    private String deliveryAddress; // 报告邮寄地址

    private String testPeroid; // 测试周期

    private String bankAccountName;  // 银行户名

    private String bankAccount; // 银行账号

    private String bankName; // 银行名称

    private String clientComSignature; // 申请公司签名

    private String libiaoRepresentativeSignature; // 立标代表签名

    private String clientComChop; // 客户盖章

    private String audit; // 审核人员签名

    private String clientSignatureDate; // 客户签名日期

    private String libiaoSignatureDate; // 立标签名日期

    private String employee; // 负责的员工

    private String customer; // 对应的客户账号

    private String remark; // 备注

    private Long testTradeId; // 绑定的检测交易ID


    private String reportFee; // 报告费

    private String courierFee; // 快递费

    private String taxFee; // 税费

    private String discount; // 折扣

    private String totalCost; // 总费用

    /**
     * 指定的客服人员Id
     */
    private Long serviceId;

    private List<TestQuotationItem> testQuotationItemList;

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

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getQuotationNum() {
        return quotationNum;
    }

    public void setQuotationNum(String quotationNum) {
        this.quotationNum = quotationNum;
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

    public String getTelCom() {
        return telCom;
    }

    public void setTelCom(String telCom) {
        this.telCom = telCom;
    }

    public String getFaxClient() {
        return faxClient;
    }

    public void setFaxClient(String faxClient) {
        this.faxClient = faxClient;
    }

    public String getFaxCom() {
        return faxCom;
    }

    public void setFaxCom(String faxCom) {
        this.faxCom = faxCom;
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

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getTestPeroid() {
        return testPeroid;
    }

    public void setTestPeroid(String testPeroid) {
        this.testPeroid = testPeroid;
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

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getTestTradeId(){
        return testTradeId;
    }

    public void setTestTradeId(Long testTradeId){
        this.testTradeId = testTradeId;
    }

    public List<TestQuotationItem> getTestQuotationItemList() {
        return testQuotationItemList;
    }

    public void setTestQuotationItemList(List<TestQuotationItem> testQuotationItemList) {
        this.testQuotationItemList = testQuotationItemList;
    }

//    public static void main(String[] args) {
//        TestQuotation testQuotation = new TestQuotation();
//        Field[] fields = testQuotation.getClass().getDeclaredFields();
//        String[] fieldName = new String[fields.length];
//        for(int i = 0; i< fields.length; i++){
//            fieldName[i] = fields[i].getName();
//            System.out.println("\"" + fields[i].getName() + "\":null,");
//        }
//    }
}