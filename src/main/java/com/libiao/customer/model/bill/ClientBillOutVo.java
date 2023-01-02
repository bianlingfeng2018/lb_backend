package com.libiao.customer.model.bill;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel("客户出账单")
public class ClientBillOutVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("客户id")
    private String clientId;
    @ApiModelProperty("报价单编号")
    private String tradeId;
    @ApiModelProperty("报价单中文名")
    private String tradeName;
    @ApiModelProperty("挂账金额")
    private Long onaccountAmt;
    @ApiModelProperty("未结算金额")
    private Long unAmt;
    @ApiModelProperty("挂账日期")
    private Date startTime;
    @ApiModelProperty("最晚收款日期")
    private Date lastTime;
    @ApiModelProperty("核销日期")
    private Date operTime;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("操作人")
    private String operUser;

}
