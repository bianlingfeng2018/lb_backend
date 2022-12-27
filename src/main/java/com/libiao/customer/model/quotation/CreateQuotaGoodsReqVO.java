package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateQuotaGoodsReqVO {

    @ApiModelProperty("商品ID")
    private Long goodsId;
    @ApiModelProperty("测试周期")
    private Integer testPeriod;
    @ApiModelProperty("测试价格")
    private Integer testPrice;
    @ApiModelProperty("样品数量")
    private String sampleNum;
    @ApiModelProperty("服务 0标准 1加急 2特级")
    private Byte service;
    @ApiModelProperty("报告类型")
    private List<Integer> reportTypes;
    @ApiModelProperty("测试项目")
    private List<QuotaGoodsItemVO> items;

}
