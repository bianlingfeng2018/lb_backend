package com.libiao.customer.model.bill;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@ApiModel
public class CustomerBillBatchReq extends BaseSessionReq {
    @ApiModelProperty("批处理列表")
    private List<CustomerBillReq> list;

}
