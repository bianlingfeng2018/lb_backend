package com.libiao.customer.model.ori;

import com.libiao.customer.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class TestItemInfoReq extends BaseRequest {

    @ApiModelProperty("测试项目ID")
    private Integer testItemId;
    @ApiModelProperty("原始记录单ID")
    private Long oriRecordId;

}
