package com.libiao.customer.model.org;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ModifyOrgReq extends BaseSessionReq {

    @ApiModelProperty("机构编号")
    @NotBlank(message = "orgNo不能为空")
    private String orgNo;

    @ApiModelProperty("机构名称")
    private String orgName;

    @ApiModelProperty("负责人")
    private Long personInCharge;

}
