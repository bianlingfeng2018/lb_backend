package com.libiao.customer.model.test;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TestInfoVO {

    @ApiModelProperty("测试方法")
    private String testMethod;
    @ApiModelProperty("测试条件列表")
    private List<TestCaseVO> caseList;

}
