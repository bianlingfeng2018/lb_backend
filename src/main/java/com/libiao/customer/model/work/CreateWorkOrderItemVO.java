package com.libiao.customer.model.work;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreateWorkOrderItemVO {

    @ApiModelProperty("检测项目ID")
    private Integer testItemId;
    @ApiModelProperty("实验室ID")
    private Integer labId;

}
