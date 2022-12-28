package com.libiao.customer.model.balance;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("佣金参数")
public class CommissionReq extends BaseSessionReq {
    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("客户ID")
    private String clientId;
    @ApiModelProperty("客户名")
    private String clientName;
    @ApiModelProperty("设置的佣金")
    private Integer rate;
    @ApiModelProperty("原因")
    private String reason;
    @ApiModelProperty("状态")
    private String status;
}
