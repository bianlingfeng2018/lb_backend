package com.libiao.customer.model.ori;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class TestItemInfoVO {

    @ApiModelProperty("1:单个限值 2:多级别限值 3:纯文本判断 4:包含测试子项目")
    private Byte type;
    @ApiModelProperty("限值说明")
    private String value;
    @ApiModelProperty("最大值")
    private String maxValue;
    @ApiModelProperty("最小值")
    private String minValue;
    @ApiModelProperty("0:大于 1:大于等于")
    private Byte containMin;
    @ApiModelProperty("0:小于 1:小于等于")
    private Byte containMax;
    @ApiModelProperty("多级别判断的列表")
    private List<TestItemInfoLvlVO> levelList;
    @ApiModelProperty("测试子项目列表")
    private List<TestItemSubInfoVO> subList;

}
