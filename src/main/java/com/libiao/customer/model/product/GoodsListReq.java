package com.libiao.customer.model.product;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class GoodsListReq extends BaseSessionReq {

    @ApiModelProperty("商品名称")
    private String goodsName;
    @ApiModelProperty("HS CODE")
    private String hsCode;
    @ApiModelProperty("出口国")
    private String export;
    @ApiModelProperty("检测标准")
    private String standard;
}
