package com.libiao.customer.model.ori;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OriRecordListReq extends BasePageReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("原始记录单编号")
    private String recordNum;
    @ApiModelProperty("审核状态 0未完成 1待审核 2审核通过 3审核不通过")
    public Byte status;

}
