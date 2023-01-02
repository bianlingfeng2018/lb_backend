package com.libiao.customer.model.client.contract;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class ClientContractListVO {

    @ApiModelProperty("客户ID")
    private Long clientId;
    @ApiModelProperty("客户编号")
    private String clientNum;
    @ApiModelProperty("客户名称")
    private String clientName;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("合同开始日期")
    private Date contractStartDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("合同结束日期")
    private Date contractEndDate;
    @ApiModelProperty("合同状态")
    private Byte contractStatus;
    @ApiModelProperty("结算周期")
    private Integer settlePeriod;
    @ApiModelProperty("可用额度")
    private Integer balanceAmt;
    @ApiModelProperty("未核销金额")
    private Integer unsettledAmt;

}
