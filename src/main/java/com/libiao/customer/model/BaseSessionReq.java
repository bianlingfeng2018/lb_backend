package com.libiao.customer.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.libiao.customer.entity.SessionUser;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseSessionReq extends BaseRequest{

    @JSONField(serialize = false)
    @ApiModelProperty(hidden = true)
    private SessionUser user;

}
