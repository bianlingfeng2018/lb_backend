package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddQuotationBillReq extends BaseRequest {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("回款金额")
    private Integer incomeAmt;
    @ApiModelProperty("文件名")
    private String billPath;

}
