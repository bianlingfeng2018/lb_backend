package com.libiao.customer.model.ori;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OriRecordDetailReq extends BaseSessionReq {

    @ApiModelProperty("原始记录单ID")
    @NotNull
    private Long id;

}
