package com.libiao.customer.model.org;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class CreateOrgReq extends BaseSessionReq {

    @ApiModelProperty("机构名称")
    private String orgName;
    @ApiModelProperty("上级机构ID")
    private String parentOrgNo;

}
