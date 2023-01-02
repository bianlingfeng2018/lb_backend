package com.libiao.customer.model.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestCaseVO {

    @ApiModelProperty("测试条件")
    private String testCase;

}
