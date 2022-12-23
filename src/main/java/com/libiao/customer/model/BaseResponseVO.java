package com.libiao.customer.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class BaseResponseVO {

    public BaseResponseVO() {
    }

    public BaseResponseVO(String errMsg) {
        this.errMsg = errMsg;
    }

    @ApiModelProperty("异常提示")
    private String errMsg;

}
