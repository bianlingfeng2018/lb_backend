package com.libiao.customer.model.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrgListVO {

    @ApiModelProperty("组织编号")
    private String orgNo;
    @ApiModelProperty("组织名称")
    private String orgName;
    @ApiModelProperty("负责人名称")
    private String username;

}
