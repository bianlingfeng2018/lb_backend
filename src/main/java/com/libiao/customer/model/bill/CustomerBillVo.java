package com.libiao.customer.model.bill;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("个人商户返回")
public class CustomerBillVo {
    private Long id;

    @ApiModelProperty("订单ID")
    private String tradeId;
    @ApiModelProperty("订单中文名")
    private String tradeName;

    @ApiModelProperty("客户ID")
    private String clientId;
    @ApiModelProperty("客户中文名")
    private String clientName;

    @ApiModelProperty("订单金额")
    private Integer orderAmt;

    @ApiModelProperty("操作金额")
    private Integer incomeAmt;

    @ApiModelProperty("水单路径")
    private String billPath;

    @ApiModelProperty("水单上传时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date uploadTime;

    @ApiModelProperty("进账时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date incomeTime;

    @ApiModelProperty("操作时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date operTime;

    @ApiModelProperty("状态")
    private Byte status;

    @ApiModelProperty("操作人")
    private String operUser;

    @ApiModelProperty("结余金额")
    private Integer settleAmt;

}
