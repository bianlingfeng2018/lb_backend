package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddQuotationBillReq extends BaseSessionReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("回款金额")
    private Integer incomeAmt;
    @ApiModelProperty("文件名")
    private String billPath;

}
