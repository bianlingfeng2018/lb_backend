package com.libiao.customer.model.bill;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@ApiModel("消费账查询入参")
public class BillOutReq extends BasePageReq {
    @ApiModelProperty(value = "客户ID",required = true)
    String clientId;
    @ApiModelProperty(value = "tradeId")
    String tradeId;
    @ApiModelProperty("发生开始时间")
    Date startTime;
    @ApiModelProperty("发生结束时间")
    Date endTime;
    @ApiModelProperty("最后收款日开始时间")
    Date lastStartTime;
    @ApiModelProperty("最后收款日结束时间")
    Date lastEndTime;
    @ApiModelProperty("状态")
    String status;

}
