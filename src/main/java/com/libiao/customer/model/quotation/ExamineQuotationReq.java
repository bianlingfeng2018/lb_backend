package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ExamineQuotationReq extends BaseSessionReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("审核结果 0不同意 1同意")
    private Byte checkResult;
    @ApiModelProperty("如果审核拒绝，填写原因")
    private String reason;

}
