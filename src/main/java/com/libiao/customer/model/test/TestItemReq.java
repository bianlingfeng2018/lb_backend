package com.libiao.customer.model.test;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestItemReq extends BaseSessionReq {

    @ApiModelProperty("测试项目ID")
    private Integer itemId;

}
