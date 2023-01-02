package com.libiao.customer.model.bill;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class CustomerBillListReq extends BasePageReq {

    @ApiModelProperty("报价单编号")
    private String tradeId;

    @ApiModelProperty("客户ID")
    private String clientId;
    @ApiModelProperty("状态")
    private Byte status;

    @ApiModelProperty("水单上传时间")
    private Date uploadStartTime;
    @ApiModelProperty("水单上传时间")
    private Date uploadEndTime;

    @ApiModelProperty("实际收款时间")
    private Date startTime;
    @ApiModelProperty("实际收款时间")
    private Date endTime;

}
