package com.libiao.customer.model.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportSampleVO {

    @ApiModelProperty("样品名称")
    private String sampleNameCn;
    @ApiModelProperty("样品名称")
    private String sampleNameEn;
    @ApiModelProperty("样品数量")
    private Integer sampleQuantity;
    @ApiModelProperty("样品模型")
    private String sampleModelCn;
    @ApiModelProperty("样品模型")
    private String sampleModelEn;
    @ApiModelProperty("样品状态")
    private String sampleStatusCn;
    @ApiModelProperty("样品状态")
    private String sampleStatusEn;
    @ApiModelProperty("商标")
    private String brandCn;
    @ApiModelProperty("商标")
    private String brandEn;
    @ApiModelProperty("批次号")
    private String lotNoCn;
    @ApiModelProperty("批次号")
    private String lotNoEn;
    @ApiModelProperty("规格")
    private String specificationCn;
    @ApiModelProperty("规格")
    private String specificationEn;
    @ApiModelProperty("供应商")
    private String supplierCn;
    @ApiModelProperty("供应商")
    private String supplierEn;
    @ApiModelProperty("购买商")
    private String buyerCn;
    @ApiModelProperty("购买商")
    private String buyerEn;
    @ApiModelProperty("订单号")
    private String orderNo;
    @ApiModelProperty("制造商")
    private String manufacturerCn;
    @ApiModelProperty("制造商")
    private String manufacturerEn;
    @ApiModelProperty("出口国")
    private String exportedTo;

}
