package com.libiao.customer.model.work;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateWorkOrderListReq extends BaseSessionReq {

    @ApiModelProperty("申请单编号")
    private String applicationNum;

    @ApiModelProperty("工作单列表")
    private List<CreateWorkOrderVO> orderList;

}
