package com.libiao.customer.model.balance;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * created at 2022/12/27 14:44 by DZL
 *
 * @package com.libiao.customer.model.balance
 */
@Data
@ApiModel
public class BalanceListReq extends BasePageReq {
    @ApiModelProperty("客户ID或名称")
    String client;
    @ApiModelProperty("客户ID或名称")
    String clientName;
    @ApiModelProperty("合同开始时间")
    Date startTime;
    @ApiModelProperty("合同结束时间")
    Date endTime;

}
