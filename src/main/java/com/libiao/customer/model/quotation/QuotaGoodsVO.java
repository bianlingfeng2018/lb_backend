package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class QuotaGoodsVO {

    @ApiModelProperty("商品ID")
    private Long goodsId;
    @ApiModelProperty("商品名称")
    private String goodsName;
    @ApiModelProperty("HSCode")
    private String hsCode;
    @ApiModelProperty("材质")
    private String material;
    @ApiModelProperty("出口国")
    private String exportCountry;
    @ApiModelProperty("检测标准")
    private String standard;
    @ApiModelProperty("测试周期")
    private Integer testPeriod;
    @ApiModelProperty("测试价格")
    private Integer testPrice;
    @ApiModelProperty("样品数量")
    private String sampleNum;
    @ApiModelProperty("服务 0标准 1加急 2特级")
    private Byte service;
    @ApiModelProperty("报告类型")
    private List<Byte> reportTypes;
    @ApiModelProperty("测试项目")
    private List<QuotaDetailItemVO> items;
    @ApiModelProperty("报告费")
    private Integer reportAmt;
    @ApiModelProperty("检测费")
    private Integer amount;
    @ApiModelProperty("加测列表")
    private List<AdditionalQuotationVO> aList;
    @ApiModelProperty("复测列表")
    private List<AdditionalQuotationVO> rList;
    @ApiModelProperty("是否有申请单")
    private boolean applied;
}
