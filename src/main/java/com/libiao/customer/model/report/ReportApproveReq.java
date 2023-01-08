package com.libiao.customer.model.report;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("报告单审核传参")
public class ReportApproveReq extends BaseSessionReq {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("reportId")
    private String  reportNum;
    @ApiModelProperty("审核状态")
    private Byte reportStatus;
    @ApiModelProperty("不通过原因")
    private String  reason;
}
