package com.libiao.customer.model.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class StandardVO {

    @ApiModelProperty("ID")
    private Integer id;
    @ApiModelProperty("名称")
    private String name;
}
