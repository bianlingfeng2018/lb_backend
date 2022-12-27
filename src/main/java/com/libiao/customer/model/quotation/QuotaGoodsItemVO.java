package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuotaGoodsItemVO {

    @ApiModelProperty("项目ID")
    private Integer itemId;
    @ApiModelProperty("测试点数")
    private Integer quantity;

}
