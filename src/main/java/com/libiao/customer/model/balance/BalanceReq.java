package com.libiao.customer.model.balance;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("余额请求参数")
public class BalanceReq extends BaseSessionReq {
    @ApiModelProperty("id")
    Long id;
    @ApiModelProperty("客户ID")
    String clientId;
    @ApiModelProperty("未结算金额")
     Long unsettledAmt;
    @ApiModelProperty("余额")
     Long balanceAmt;
    @ApiModelProperty("授信额度")
     Long creditLimit;
    @ApiModelProperty("佣金比")
     Long commissionRate;
    @ApiModelProperty("未结算佣金")
     Long unsettleCommission;

}
