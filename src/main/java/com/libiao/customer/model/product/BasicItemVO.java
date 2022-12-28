package com.libiao.customer.model.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BasicItemVO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("检测项目")
    private String name;
    @ApiModelProperty("单位")
    private String unit;
    @ApiModelProperty("单价分")
    private Integer price;
    @ApiModelProperty("测试周期")
    private String period;

}
