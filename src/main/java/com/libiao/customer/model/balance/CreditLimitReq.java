package com.libiao.customer.model.balance;

import com.libiao.customer.entity.SessionUser;
import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("授信额度请求参数")
public class CreditLimitReq extends BaseSessionReq {

    @ApiModelProperty("客户Id")
    String clientId;

    @ApiModelProperty("授信额度")
    Long creditLimit;

}
