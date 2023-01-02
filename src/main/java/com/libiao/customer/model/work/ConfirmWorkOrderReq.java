package com.libiao.customer.model.work;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ConfirmWorkOrderReq extends BaseSessionReq {

    @ApiModelProperty("工作单ID")
    private Long id;
    @ApiModelProperty("样品图片名称")
    private String fileName;

}
