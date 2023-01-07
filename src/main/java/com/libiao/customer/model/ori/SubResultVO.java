package com.libiao.customer.model.ori;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SubResultVO {

    @ApiModelProperty("原始记录单的测试子项目的id")
    private Long id;
    @ApiModelProperty("平均值")
    private String avgValue;
    @ApiModelProperty("测试结果")
    private String testResult;

}
