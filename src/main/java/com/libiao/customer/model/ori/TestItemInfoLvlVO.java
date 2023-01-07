package com.libiao.customer.model.ori;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestItemInfoLvlVO {
    @ApiModelProperty("级别名称")
    private String levelName;
    @ApiModelProperty("最大值")
    private String maxValue;
    @ApiModelProperty("最小值")
    private String minValue;
    @ApiModelProperty("0:大于 1:大于等于")
    private Byte containMin;
    @ApiModelProperty("0:小于 1:小于等于")
    private Byte containMax;
}
