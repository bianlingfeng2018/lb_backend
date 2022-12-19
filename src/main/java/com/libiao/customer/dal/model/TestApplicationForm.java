package com.libiao.customer.dal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestApplicationForm {
    private Long id;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportDate; // 右上方Report Date

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date recDate; // 右上方的Rec Date

    private String csName; // 右上方的CS Name

    private String reportNum; // 右上方的Reprot Num

    private String applicationName; // 申请单位名称

    private String applicationAddress; // 申请单位地址

    private String reportTitle; // 报告抬头

    private String sameAsApplicant; // 同申请方

    private String otherName; // 其他名称

    private String otherAddress; // 其他地址

    private String contact; // 联系人

    private String tel; // 电话

    private String fax; // 传真

    private String email; // 电邮

    private String deliveredTo; // 报告寄送

    private String payer; // 付款方

    private String invoiceTitle; // 发票抬头

    private String sampleName; // 样品名称

    private String sampleQuantity;  // 样品数量

    private String sampleModel;  // 样品型号

    private String brand;  // 样品商标

    private String lotNo;  // 样品批号

    private String specification;  // 规格

    private String supplier;  // 供应商

    private String poNum;  // 订单号

    private String buyer;  // 购买商

    private String manufacturer;  // 生产商

    private String exportedTo;  //  出口地

    private String originCountry;  // 生产国

    private String language;  // 语言

    private String reportFormat;  // 报告格式

    private String reportType;  // 报告方式

    private String agreeToSubcontract;  // 是否同意分包

    private String serviceType;  // 服务类型

    private String testRequirement;  // 测试要求

    private String sampleTreatment;  // 样品处理方式

    private String applicantSigCop;  // 申请公司签名

    private String applicationDate;  // 申请日期

    private String employee;  // 员工

    private String customer;  // 顾客

    private Long testTradeId;  // 检测交易id

    private String copyNum;  // 顾客

    private String flexObj;

    private List<TestApplicationItem> testApplicationItemList;  // 通用测试申请表详情

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getRecDate() {
        return recDate;
    }

    public void setRecDate(Date recDate) {
        this.recDate = recDate;
    }

    public String getCsName() {
        return csName;
    }

    public void setCsName(String csName) {
        this.csName = csName;
    }

    public String getReportNum() {
        return reportNum;
    }

    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationAddress() {
        return applicationAddress;
    }

    public void setApplicationAddress(String applicationAddress) {
        this.applicationAddress = applicationAddress;
    }

    public String getReportTitle() {
        return reportTitle;
    }

    public void setReportTitle(String reportTitle) {
        this.reportTitle = reportTitle;
    }

    public String getSameAsApplicant() {
        return sameAsApplicant;
    }

    public void setSameAsApplicant(String sameAsApplicant) {
        this.sameAsApplicant = sameAsApplicant;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getOtherAddress() {
        return otherAddress;
    }

    public void setOtherAddress(String otherAddress) {
        this.otherAddress = otherAddress;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeliveredTo() {
        return deliveredTo;
    }

    public void setDeliveredTo(String deliveredTo) {
        this.deliveredTo = deliveredTo;
    }

    public String getPayer() {
        return payer;
    }

    public void setPayer(String payer) {
        this.payer = payer;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    public String getSampleName() {
        return sampleName;
    }

    public void setSampleName(String sampleName) {
        this.sampleName = sampleName;
    }

    public String getSampleQuantity() {
        return sampleQuantity;
    }

    public void setSampleQuantity(String sampleQuantity) {
        this.sampleQuantity = sampleQuantity;
    }

    public String getSampleModel() {
        return sampleModel;
    }

    public void setSampleModel(String sampleModel) {
        this.sampleModel = sampleModel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLotNo() {
        return lotNo;
    }

    public void setLotNo(String lotNo) {
        this.lotNo = lotNo;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getPoNum() {
        return poNum;
    }

    public void setPoNum(String poNum) {
        this.poNum = poNum;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getExportedTo() {
        return exportedTo;
    }

    public void setExportedTo(String exportedTo) {
        this.exportedTo = exportedTo;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getReportFormat() {
        return reportFormat;
    }

    public void setReportFormat(String reportFormat) {
        this.reportFormat = reportFormat;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getAgreeToSubcontract() {
        return agreeToSubcontract;
    }

    public void setAgreeToSubcontract(String agreeToSubcontract) {
        this.agreeToSubcontract = agreeToSubcontract;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getSampleTreatment() {
        return sampleTreatment;
    }

    public void setSampleTreatment(String sampleTreatment) {
        this.sampleTreatment = sampleTreatment;
    }

    public String getApplicantSigCop() {
        return applicantSigCop;
    }

    public void setApplicantSigCop(String applicantSigCop) {
        this.applicantSigCop = applicantSigCop;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
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

    public String getTestRequirement() {
        return testRequirement;
    }

    public void setTestRequirement(String testRequirement) {
        this.testRequirement = testRequirement;
    }

    public List<TestApplicationItem> getTestApplicationItemList() {
        return testApplicationItemList;
    }

    public void setTestApplicationItemList(List<TestApplicationItem> testApplicationItemList) {
        this.testApplicationItemList = testApplicationItemList;
    }

    public Long getTestTradeId(){
        return testTradeId;
    }

    public void setTestTradeId(Long testTradeId){
        this.testTradeId = testTradeId;
    }

        public static void main(String[] args) {
        TestApplicationForm testApplicationForm = new TestApplicationForm();
        Field[] fields = testApplicationForm.getClass().getDeclaredFields();
        String[] fieldName = new String[fields.length];
        for(int i = 0; i< fields.length; i++){
            fieldName[i] = fields[i].getName();
            System.out.println("\"" + fields[i].getName() + "\":\"\",");
        }
    }
}