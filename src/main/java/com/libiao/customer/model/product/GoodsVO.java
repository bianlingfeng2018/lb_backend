package com.libiao.customer.model.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class GoodsVO {

    @ApiModelProperty("ID")
    private Long goodsId;
    @ApiModelProperty("商品编号")
    private String goodsNum;
    @ApiModelProperty("商品名称")
    private String goodsName;
    @ApiModelProperty("HS CODE")
    private String hsCode;
    @ApiModelProperty("材质")
    private String material;
    @ApiModelProperty("出口国")
    private String export;
    @ApiModelProperty("检测标准")
    private String standard;
    @ApiModelProperty("检测项列表")
    List<BasicItemVO> items;

}
