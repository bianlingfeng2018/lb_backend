package com.libiao.customer.model.work;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CheckItemVO {

    @ApiModelProperty("实验室ID")
    private Integer labId;
    @ApiModelProperty("实验室名称")
    private String labName;
    @ApiModelProperty("设备名称")
    private String deviceName;
    @ApiModelProperty("测试项目ID")
    private Integer itemId;
    @ApiModelProperty("单价")
    private Integer unitPrice;
    @ApiModelProperty("测试金额")
    private Integer amountRmb;
    @ApiModelProperty("测试项目")
    private String itemName;
    @ApiModelProperty("测试周期")
    private Integer period;
}
