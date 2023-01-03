package com.libiao.customer.model.ori;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class ReviewOriRecordReq extends BaseSessionReq {

    @NotNull
    @ApiModelProperty("原始记录单ID")
    private Long id;
    //0未完成 1待审核
    @Min(2)
    @Max(3)
    @ApiModelProperty("2审核通过 3审核不通过")
    private Byte status;
    @ApiModelProperty("拒绝理由")
    private String reviewReason;

}
