package com.libiao.customer.model.work;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class WorkOrderListVO {

    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("工作单编号")
    private String workOrderNum;
    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("申请单编号")
    private String applicationNum;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("开单日期")
    private Date orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("出单日期")
    private Date outputDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("要求完成日期")
    private Date planDate;
    @ApiModelProperty("是否加急 0不加急  1加急 2特急")
    private Byte service;
    @ApiModelProperty("检测单位ID")
    private Integer testComId;
    @ApiModelProperty("检测单位名称")
    private String comName;
    @ApiModelProperty("是否分包商 0否 1是")
    private Byte subContract;
    @ApiModelProperty("状态 0待确认 1已确认")
    private Byte status;

}
