package com.libiao.customer.model.org;

import com.libiao.customer.model.BasePageReq;
import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class SubOrgListReq extends BasePageReq {

    @ApiModelProperty("上级机构ID")
    private String parentOrgNo;

}
