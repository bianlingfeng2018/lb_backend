package com.libiao.customer.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseRequest {

    @ApiModelProperty("请求ID（24位随机字符串）")
    private String requestId;
}
