package com.libiao.customer.model.balance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("佣金明细")
public class CommissionRecordVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("客户id")
    private String clientId;
    @ApiModelProperty("操作人")
    private String operUser;
    @ApiModelProperty("佣金比")
    private Integer rate;
    @ApiModelProperty("操作时间")
    private Date operTime;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("交易金额")
    private Long tradeAmt;
    @ApiModelProperty("描述")
    private String descp;
    @ApiModelProperty("佣金")
    private Long amount;
    @ApiModelProperty("交易id")
    private String tradeId;
    @ApiModelProperty("交易名称")
    private String tradeName;
    @ApiModelProperty("公司名称")
    private String clientName;
}
