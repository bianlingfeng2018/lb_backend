package com.libiao.customer.model.org;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrgComboVO {

    @ApiModelProperty("组织编号")
    private String orgNo;
    @ApiModelProperty("组织名称")
    private String orgName;
    @ApiModelProperty("子节点")
    private List<OrgComboVO> subOrgList;
}
