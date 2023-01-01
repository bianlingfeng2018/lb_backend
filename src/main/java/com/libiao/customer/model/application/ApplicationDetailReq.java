package com.libiao.customer.model.application;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
public class ApplicationDetailReq extends BaseSessionReq {

    @NotBlank(message = "申请单号不能为空")
    @ApiModelProperty("申请单编号")
    private String applicationNum;

}
