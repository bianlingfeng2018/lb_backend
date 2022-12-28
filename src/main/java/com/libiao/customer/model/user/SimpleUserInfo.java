package com.libiao.customer.model.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SimpleUserInfo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("昵称")
    private String nickname;
}
