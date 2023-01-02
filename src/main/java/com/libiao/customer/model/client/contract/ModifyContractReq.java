package com.libiao.customer.model.client.contract;

import com.libiao.customer.model.BaseRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ModifyContractReq extends BaseRequest {

    @ApiModelProperty("客户ID")
    private Long clientId;
    @ApiModelProperty("合同开始日期")
    private Date contractStartDate;
    @ApiModelProperty("合同结束日期")
    private Date contractEndDate;
    @ApiModelProperty("结算周期")
    private Integer settlePeriod;
    @ApiModelProperty("是否挂账 0否 1是")
    private Byte type;
    @ApiModelProperty("上传接口返回的文件名称")
    private String contractPath;
}
