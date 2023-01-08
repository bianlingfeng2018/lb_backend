package com.libiao.customer.model.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubTestResultVO {

    @ApiModelProperty("测试项目")
    private String subTestItem;
    @ApiModelProperty("限值")
    private String limitValue;
    @ApiModelProperty("测试结果")
    private String testResult;
    @ApiModelProperty("测试数值")
    private String avgValue;

}
