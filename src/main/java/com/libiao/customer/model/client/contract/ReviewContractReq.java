package com.libiao.customer.model.client.contract;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReviewContractReq extends BaseSessionReq {

    @ApiModelProperty("客户ID")
    private Long clientId;
    @ApiModelProperty("审核拒绝原因")
    private String reviewReason;
    @ApiModelProperty("审核结果 1通过 2拒绝")
    private Byte reviewStatus;
}
