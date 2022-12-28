package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class QuotationListReq extends BasePageReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;

    @ApiModelProperty("客户中文名称")
    private String clientName;

    @ApiModelProperty("检测交易名称")
    private String tradeName;

    @ApiModelProperty("进度")
    private Byte step;

    @ApiModelProperty("支付状态")
    private Byte payStatus;

    @ApiModelProperty("跟进的客服ID")
    private Long serviceId;

}
