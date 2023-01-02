package com.libiao.customer.model.client.contract;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ClientContractListReq extends BasePageReq {

    @ApiModelProperty("客户名称")
    private String clientName;
    @ApiModelProperty("合同结束日期-开始")
    private String contractStartDate;
    @ApiModelProperty("合同结束日期-结束")
    private String contractEndDate;

}
