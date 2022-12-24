package com.libiao.customer.model.bill;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class BillIncomeAddReq extends BaseSessionReq {
    @ApiModelProperty("客户ID")
    String clientId;
    @ApiModelProperty("操作金额")
    Long operAmount;
    @ApiModelProperty("备注")
    String desc;
    @ApiModelProperty(value = "操作类型")
    String operType;

}
