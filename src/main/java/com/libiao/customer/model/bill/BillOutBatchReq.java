package com.libiao.customer.model.bill;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class BillOutBatchReq extends BaseSessionReq {
    @ApiModelProperty("客户ID")
    String clientId;

    @ApiModelProperty
    List<Long> ids;
}
