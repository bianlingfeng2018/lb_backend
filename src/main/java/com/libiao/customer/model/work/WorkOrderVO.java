package com.libiao.customer.model.work;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class WorkOrderVO {

    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("工作单编号")
    private String workOrderNum;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("开单时间")
    private Date orderDate;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty("出单日期")
    private Date outputDate;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("要求完成日期")
    private Date planDate;
    @ApiModelProperty("加急情况 0不加 1加急 2特急")
    private Byte service;
    @ApiModelProperty("检测公司ID")
    private Integer testComId;
    @ApiModelProperty("检测公司名称")
    private String comName;
    @ApiModelProperty("客户名称")
    private String clientName;
    @ApiModelProperty("开单人")
    private String createName;
    @ApiModelProperty("是否退样 0否 1是")
    private Byte sampleStatus;
    @ApiModelProperty("测试项列表")
    private List<WorkOrderItemVO> itemList;
    @ApiModelProperty("样品图片列表")
    private List<String> fileNameList;
}
