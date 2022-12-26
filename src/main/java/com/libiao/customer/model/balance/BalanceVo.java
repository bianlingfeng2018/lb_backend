package com.libiao.customer.model.balance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("账户资金余额")
public class BalanceVo {

    @ApiModelProperty("客户ID")
    String clientId;
    @ApiModelProperty("账户余额")
    Long balanceAmt;
    @ApiModelProperty("未结算的资金")
    Long unsettledAmt;
    @ApiModelProperty("授信额度")
    Long creditLimit;
    @ApiModelProperty("佣金比")
    Long commissionRate;
    @ApiModelProperty("未结算的佣金")
    Long unsettleCommission;

}
