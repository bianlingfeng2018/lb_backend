package com.libiao.customer.model.balance;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel("修改佣金记录参数")
public class CommissionRecordBatchReq extends BaseSessionReq {

    @ApiModelProperty("结算日期")
    private List<CommissionRecordReq> list;

}
