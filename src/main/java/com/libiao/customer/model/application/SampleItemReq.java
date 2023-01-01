package com.libiao.customer.model.application;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SampleItemReq {

    @ApiModelProperty("测试项目DI")
    private Integer testItemId;
    @ApiModelProperty("测试名称")
    private String itemName;
    @ApiModelProperty("测试方法")
    private String testMethod;
    @ApiModelProperty("测试条件")
    private String testCase;
    @ApiModelProperty("备注")
    private String remark;
}
