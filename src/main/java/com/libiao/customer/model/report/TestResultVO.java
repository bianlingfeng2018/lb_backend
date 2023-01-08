package com.libiao.customer.model.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TestResultVO {

    @ApiModelProperty("测试项目")
    private String testItem;
    @ApiModelProperty("测试数值")
    private String testValue;
    @ApiModelProperty("测试结果")
    private String testResult;
    @ApiModelProperty("测试人员")
    private String testPerson;
    @ApiModelProperty("报告时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportDate;
    @ApiModelProperty("测试限值")
    private String limitValue;
    @ApiModelProperty("测试子项目")
    private List<SubTestResultVO> subList;
}
