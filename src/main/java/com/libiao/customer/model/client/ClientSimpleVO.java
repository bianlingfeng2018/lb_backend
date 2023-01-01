package com.libiao.customer.model.client;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientSimpleVO {

    @ApiModelProperty("客户ID")
    private Long id;
    @ApiModelProperty("公司名称")
    private String name;
    @ApiModelProperty("联系人姓名")
    private String contactName;
    @ApiModelProperty("联系人电话")
    private String contactMobile;
    @ApiModelProperty("联系人邮箱")
    private String contactEmail;
    @ApiModelProperty("公司地址")
    private String addr;
}
