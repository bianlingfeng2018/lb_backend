package com.libiao.customer.model.ori;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OriRecordDetailVO {

    @ApiModelProperty("原始记录单编号")
    private String recordNum;
    @ApiModelProperty("测试项目")
    private String testItem;
    @ApiModelProperty("检测公司名称")
    private String testom;
    @ApiModelProperty("检测设备号")
    private String testDeviceNo;
    @ApiModelProperty("检测设备")
    private String testDeviceName;
    @ApiModelProperty("测试人员")
    private String testPerson;
    @ApiModelProperty("测试方法")
    private String testMethod;
    @ApiModelProperty("测试条件")
    private String testCase;
    @ApiModelProperty("要求完成日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date planDate;
    @ApiModelProperty("报告日期")
    private Date reportDate;
    @ApiModelProperty("状态 0未完成 1待审核 2审核通过 3审核不通过")
    private Byte status;
    @ApiModelProperty("测试结果")
    private String testResult;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("收样日期")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date sampleDate;
    @ApiModelProperty("审核人")
    private String reviewName;
    @ApiModelProperty("审核拒绝原因")
    private String reviewReason;
    @ApiModelProperty("审核时间")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date reviewTime;
    @ApiModelProperty("报告人")
    private String reportPerson;
    @ApiModelProperty("原始纸质记录文件地址")
    private String oriReportFile;
    @ApiModelProperty("测试子项目列表")
    private List<OriRecordSubItemVO> subList;

}
