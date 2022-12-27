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
    @ApiModelProperty("报告类型")
    private List<Integer> reportTypes;
    @ApiModelProperty("测试项目")
    private List<QuotaGoodsItemVO> items;

}
