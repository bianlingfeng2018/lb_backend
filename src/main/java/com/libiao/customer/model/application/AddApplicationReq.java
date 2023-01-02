package com.libiao.customer.model.application;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class AddApplicationReq extends BaseSessionReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("申请单位地址")
    private String comAddrCn;
    @ApiModelProperty("申请单位地址")
    private String comAddrEn;
    @ApiModelProperty("报告抬头")
    private String reportTitleCn;
    @ApiModelProperty("报告抬头")
    private String reportTitleEn;
    @ApiModelProperty("报告抬头地址")
    private String reportAddressCn;
    @ApiModelProperty("报告抬头地址")
    private String reportAddressEn;
    @ApiModelProperty("报告邮寄地址")
    private String reportAddr;
    @ApiModelProperty("发票抬头")
    private String invoiceTitle;
    @ApiModelProperty("需要资质，1CNAS,2CMA")
    private List<Integer> credentials;
    @ApiModelProperty("样品名称")
    private String sampleNameCn;
    @ApiModelProperty("样品名称")
    private String sampleNameEn;
    @ApiModelProperty("样品数量")
    private String sampleQuantity;
    @ApiModelProperty("样品型号")
    private String sampleModelCn;
    @ApiModelProperty("样品型号")
    private String sampleModelEn;
    @ApiModelProperty("样品状态")
    private String sampleStatusCn;
    @ApiModelProperty("样品状态")
    private String sampleStatusEn;
    @ApiModelProperty("商标")
    private String brandCn;
    @ApiModelProperty("商标")
    private String brandEn;
    @ApiModelProperty("批次")
    private String lotNoCn;
    @ApiModelProperty("批次")
    private String lotNoEn;
    @ApiModelProperty("规格")
    private String specificationCn;
    @ApiModelProperty("规格")
    private String specificationEn;
    @ApiModelProperty("供应商")
    private String supplierCn;
    @ApiModelProperty("供应商")
    private String supplierEn;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("购买商")
    private String buyerCn;
    @ApiModelProperty("购买商")
    private String buyerEn;
    @ApiModelProperty("生产商")
    private String manufacturerCn;
    @ApiModelProperty("生产商")
    private String manufacturerEn;
    @ApiModelProperty("出口地")//TODO 确认是否多选
    private String exportedTo;
    @ApiModelProperty("生产国")
    private String originCountry;
    @ApiModelProperty("样品处理方式 1退还 2留样")
    private Byte sampleDeal;
    @ApiModelProperty("多样品材料清单")
    private List<SampleTestReq> sampleList;
}
