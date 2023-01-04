package com.libiao.customer.model.report;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportListReq extends BasePageReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("报告单编号")
    private String reportNum;
    @ApiModelProperty("客户名称")
    private String client;
    @ApiModelProperty("报告状态 0待审核 1审核通过 2审核不通过")
    private Byte reportStatus;
}
