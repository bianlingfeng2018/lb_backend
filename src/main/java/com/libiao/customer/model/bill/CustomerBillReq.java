package com.libiao.customer.model.bill;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class CustomerBillReq extends BaseSessionReq {

    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("报价单ID")
    private String tradeId;
    @ApiModelProperty("客户ID")
    private String clientId;

    @ApiModelProperty("交易金额")
    private Long orderAmt;

    @ApiModelProperty("回款金额")
    private Long incomeAmt;

    @ApiModelProperty("水单路径")
    private String billPath;

    @ApiModelProperty("水单上传时间")
    private Date uploadTime;

    @ApiModelProperty("收款时间")
    private Date incomeTime;

    @ApiModelProperty("状态")
    private Byte status;

}
