package com.libiao.customer.model.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CountryVO {

    @ApiModelProperty("id")
    private Integer id;
    @ApiModelProperty("代码")
    private String code;
    @ApiModelProperty("英文简称")
    private String abbr;
    @ApiModelProperty("中文名称")
    private String name;
    @ApiModelProperty("英文名称")
    private String enName;

}
