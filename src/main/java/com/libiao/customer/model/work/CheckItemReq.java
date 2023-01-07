package com.libiao.customer.model.work;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CheckItemReq extends BaseSessionReq {

    @ApiModelProperty("公司ID")
    private Integer comId;
    @ApiModelProperty("申请单号")
    private String applicationNum;

}
