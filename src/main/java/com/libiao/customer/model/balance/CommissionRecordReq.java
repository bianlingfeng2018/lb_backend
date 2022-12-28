package com.libiao.customer.model.balance;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("修改佣金记录参数")
public class CommissionRecordReq extends BaseSessionReq {

    @ApiModelProperty(value = "记录ID",required = true)
    private Long id;

    @ApiModelProperty("结算日期")
    private Date settleTime;

}
