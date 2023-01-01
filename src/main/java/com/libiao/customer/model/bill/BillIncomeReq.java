package com.libiao.customer.model.bill;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
@ApiModel("入账查询入参")
public class BillIncomeReq extends BasePageReq {
    @ApiModelProperty("id")
    Integer id;
    @ApiModelProperty(value = "客户ID" ,required = true)
    String clientId;
    @ApiModelProperty("查询开始时间")
    Date startTime;
    @ApiModelProperty("查询结束时间")
    Date endTime;
    @ApiModelProperty("操作类型")
    String operType;


}
