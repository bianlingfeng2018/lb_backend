package com.libiao.customer.model.application;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ApplicationListReq extends BasePageReq {

    @ApiModelProperty("申请单编号")
    private String applicationNum;
    @ApiModelProperty("申请单号名称")
    private String applicationName;
    @ApiModelProperty("收样状态 0未收1已收")
    private Byte sampleStatus;
    @ApiModelProperty("合同状态 0待审核 1评审通过 2评审不通过 3已下单")
    private Byte contractStatus;
}
