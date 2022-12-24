package com.libiao.customer.model.bill;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

@Data
@ApiModel
public class BillOutAddReq extends BaseSessionReq {
    @ApiModelProperty(value = "消费账ID",required = true)
    Long id;
    @ApiModelProperty("客户ID")
    String clientId;
    @ApiModelProperty("交易ID")
    String tradeId;
    @ApiModelProperty("操作金额")
    Long operAmount;
}
