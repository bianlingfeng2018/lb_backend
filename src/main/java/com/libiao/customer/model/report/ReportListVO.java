package com.libiao.customer.model.report;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ReportListVO {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("报告单编号")
    private String reportNum;
    @ApiModelProperty("报告日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reportDate;
    @ApiModelProperty("要求日期")
    private String planDate;
    @ApiModelProperty("客户名称")
    private String client;
    @ApiModelProperty("测试人员")
    private String tester;
    @ApiModelProperty("报告状态")
    private Byte reportStatus;
    @ApiModelProperty("不通过原因")
    private String reason;
}
