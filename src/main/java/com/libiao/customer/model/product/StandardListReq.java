package com.libiao.customer.model.product;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StandardListReq extends BasePageReq {

    @ApiModelProperty("标准名称")
    private String name;
}
