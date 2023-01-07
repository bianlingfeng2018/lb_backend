package com.libiao.customer.model.work;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CheckComListReq extends BaseSessionReq {

    @NotBlank
    @ApiModelProperty("公司名称")
    private String comName;
}
