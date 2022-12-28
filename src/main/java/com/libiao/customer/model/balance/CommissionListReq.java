package com.libiao.customer.model.balance;

import com.libiao.customer.model.BasePageReq;
import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("佣金列表请求参数")
public class CommissionListReq extends BasePageReq {

    @ApiModelProperty("客户ID")
    private String clientId;
    @ApiModelProperty("客户Name")
    private String clientName;

}
