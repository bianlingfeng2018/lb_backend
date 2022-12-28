package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;
import lombok.Data;

@Data
public class QuotaDetailItemVO {

    @ApiModelProperty("项目ID")
    private Integer itemId;
    @ApiModelProperty("测试点数")
    private Integer quantity;
    @ApiModelProperty("检测项目")
    private String testItem;
    @ApiModelProperty("检测单价")
    private Integer unitPrice;
    @ApiModelProperty("样品量")
    private Integer sampleQty;
    @ApiModelProperty("测试金额")
    private Integer amountRmb;
}
