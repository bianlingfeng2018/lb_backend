package com.libiao.customer.model.ori;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestItemSubInfoVO {

    @ApiModelProperty("原始记录单的测试子项目的id")
    private Long id;
    @ApiModelProperty("测试子项目")
    private String subTestItem;
    @ApiModelProperty("CAS")
    private String cas;
    @ApiModelProperty("限值")
    private String limitValue;
}
