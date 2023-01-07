package com.libiao.customer.model.balance;

import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
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
