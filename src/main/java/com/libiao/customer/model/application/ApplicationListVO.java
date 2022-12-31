package com.libiao.customer.model.application;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ApplicationListVO {

    @ApiModelProperty("申请单编号")
    private String applicationNum;
    @ApiModelProperty("申请单位名称")
    private String applicationName;
    @ApiModelProperty("申请日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date applicationDate;
    @ApiModelProperty("收样状态0未收 1已收")
    private Byte sampleStatus;
    @ApiModelProperty("样品接收日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sampleDate;
    @ApiModelProperty("要求完成日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planDate;
    @ApiModelProperty("评审人")
    private String reviewName;
    @ApiModelProperty("跟进人")
    private String serviceName;

}
