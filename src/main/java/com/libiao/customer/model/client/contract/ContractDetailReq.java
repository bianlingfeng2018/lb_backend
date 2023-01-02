package com.libiao.customer.model.client.contract;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ContractDetailReq extends BaseSessionReq {

    @ApiModelProperty("客户ID")
    private Long clientId;

}
