package com.libiao.customer.model.balance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * created at 2022/12/28 15:39 by DZL
 *
 * @package com.libiao.customer.model.balance
 */
@Data
@ApiModel("佣金返回")
public class CommissionVo {
    @ApiModelProperty("id")
    private Long id;
    @ApiModelProperty("客户id")
    private String clientId;
    @ApiModelProperty("客户名")
    private String clientName;
    @ApiModelProperty("当前佣金")
    private Integer rate;
    @ApiModelProperty("状态")
    private String status;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("审核时间")
    private Date approveTime;
    @ApiModelProperty("不通过原因")
    private String reason;
    @ApiModelProperty("审核中的佣金")
    private Integer inreviewRate;
    @ApiModelProperty("审核人")
    private String approveUser;
    @ApiModelProperty("未结算佣金")
    private Long unsettleCommission;
}
