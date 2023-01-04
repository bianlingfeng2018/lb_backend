package com.libiao.customer.model.work;

import com.libiao.customer.model.BasePageReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WorkOrderListReq extends BasePageReq {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("工作单编号")
    private String workOrderNum;
    @ApiModelProperty("检测单位名称")
    private String comName;
    @ApiModelProperty("是否分包商 0否 1是")
    private Byte subContract;
    @ApiModelProperty("状态 0待确认 1已确认")
    private Byte status;
    @ApiModelProperty("出单日期-开始 yyyy-MM-dd")
    private String orderDateStart;
    @ApiModelProperty("出单日期-结束 yyyy-MM-dd")
    private String orderDateEnd;
    @ApiModelProperty("要求日期-开始 yyyy-MM-dd")
    private String planDateStart;
    @ApiModelProperty("要求日期-结束 yyyy-MM-dd")
    private String planDateEnd;

}

