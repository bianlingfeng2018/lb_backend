package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class QuotationListReq extends BasePageReq {

    @ApiModelProperty("报价单编号")
    private String quotationId;

    @ApiModelProperty("进度")
    private Integer state;

}
