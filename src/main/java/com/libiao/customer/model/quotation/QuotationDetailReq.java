package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class QuotationDetailReq extends BaseSessionReq {

    @ApiModelProperty("报告单号")
    private String quotationNum;

}
