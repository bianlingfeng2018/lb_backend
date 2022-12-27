package com.libiao.customer.model.org;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import static com.libiao.customer.service.impl.OrgServiceImpl.TOP_ORG;

@Data
@ApiModel
public class CreateOrgReq extends BaseSessionReq {

    @ApiModelProperty("机构名称")
    private String orgName;
    //默认为最上级
    @ApiModelProperty("上级机构ID")
    private String parentOrgNo = TOP_ORG;

}
