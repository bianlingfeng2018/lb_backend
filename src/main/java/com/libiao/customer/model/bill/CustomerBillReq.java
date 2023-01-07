package com.libiao.customer.model.bill;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat
    private String uploadTime;

    @ApiModelProperty("收款时间")
    @DateTimeFormat
    private String incomeTime;

    @ApiModelProperty("状态")
    private Byte status;

}
