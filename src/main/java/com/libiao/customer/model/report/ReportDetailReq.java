package com.libiao.customer.model.report;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ReportDetailReq extends BaseSessionReq {

    @NotNull
    @ApiModelProperty("检测报告单ID")
    private Long TestReportId;
}
