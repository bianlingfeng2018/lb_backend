package com.libiao.customer.model.client;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientSimpleReq extends BaseSessionReq {

    @ApiModelProperty("客户公司名称")
    private String clientName;

}
