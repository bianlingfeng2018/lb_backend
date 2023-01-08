package com.libiao.customer.model.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ReportDetailVO {

    @ApiModelProperty("报告编号")
    private String reportNum;
    @ApiModelProperty("客户")
    private String client;
    @ApiModelProperty("编制人")
    private String editor;
    @ApiModelProperty("报告日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportDate;
    @ApiModelProperty("线路负责人")
    private String charger;
    @ApiModelProperty("审核人")
    private String reviewer;
    @ApiModelProperty("审批人")
    private String approver;

    @ApiModelProperty("样品信息")
    private ReportSampleVO sample;
    @ApiModelProperty("样品描述")
    private List<ReportSampleDescVO> descList;
    @ApiModelProperty("测试结果")
    private List<TestResultVO> testResult;
}
