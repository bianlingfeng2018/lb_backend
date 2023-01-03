package com.libiao.customer.model.ori;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OriRecordSubItemVO {

    @ApiModelProperty("测试子项目")
    private String subTestItem;
    @ApiModelProperty("cas")
    private String cas;
    @ApiModelProperty("平均值")
    private String avgValue;
    @ApiModelProperty("限值")
    private String limitValue;
    @ApiModelProperty("测试结果")
    private String testResult;
}
