package com.libiao.customer.model.application;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class SampleTestReq {

    @ApiModelProperty("样品名称")
    private String sampleName;
    @ApiModelProperty("样品型号")
    private String sampleModel;
    @ApiModelProperty("样品材质")
    private String sampleMaterial;
    @ApiModelProperty("样品描述")
    private String sampleDescription;
    @ApiModelProperty("测试项目列表")
    private List<SampleItemReq> itemList;

}
