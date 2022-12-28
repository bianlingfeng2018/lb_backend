package com.libiao.customer.model.balance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("账户资金余额")
public class BalanceVo {

    @ApiModelProperty("客户ID")
    String clientId;
    @ApiModelProperty("客户名称")
    String name;
    @ApiModelProperty("账户余额")
    Long balanceAmt;
    @ApiModelProperty("未结算的资金")
    Long unsettledAmt;
    @ApiModelProperty("授信额度")
    Long creditLimit;
    @ApiModelProperty("未结算的佣金")
    Long unsettleCommission;
    @ApiModelProperty("剩余收款金额")
    Long leftIncomeAmt;

}
