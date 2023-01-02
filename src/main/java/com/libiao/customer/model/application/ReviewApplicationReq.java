package com.libiao.customer.model.application;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ReviewApplicationReq extends BaseSessionReq {

    @ApiModelProperty("申请单编号")
    @NotBlank
    private String applicationNum;
    @NotNull
    @ApiModelProperty("审核结果 1通过 2没通过 ")
    private Byte reviewResult;
    @ApiModelProperty("审核不通过的原因")
    private String reason;
}
