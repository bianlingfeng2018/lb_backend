package com.libiao.customer.model.ori;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OriRecordListVO {

    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("原始记录单编号")
    private String recordNum;
    @ApiModelProperty("工作单编号")
    private String workOrderNum;
    @ApiModelProperty("报告单编号")
    private String reportNum;
    @ApiModelProperty("检测项目")
    private String testItem;
    @ApiModelProperty("检测项目ID")
    private Integer testItemId;
    @ApiModelProperty("实验室")
    private String testLab;
    @ApiModelProperty("检测设备号")
    private String testDeviceNo;
    @ApiModelProperty("测试人员编号")
    private String testPersonId;
    @ApiModelProperty("测试人员")
    private String testPerson;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("创建时间")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("要求日期")
    private Date planDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("报告日期")
    private Date reportDate;
    @ApiModelProperty("状态 0未完成 1待审核 2审核通过 3审核不通过")
    private Byte status;

}
