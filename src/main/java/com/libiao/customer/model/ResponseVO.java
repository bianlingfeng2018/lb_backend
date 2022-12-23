package com.libiao.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class ResponseVO<T> extends BaseResponseVO{

    public ResponseVO(T data) {
        this.data = data;
    }

    @ApiModelProperty("数据")
    private T data;

}
