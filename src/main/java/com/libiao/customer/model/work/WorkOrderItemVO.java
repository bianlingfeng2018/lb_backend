package com.libiao.customer.model.work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel
public class WorkOrderItemVO {

    @ApiModelProperty(" 样品部位名称")
    private String sampleLocation;
    @ApiModelProperty("样品型号")
    private String sampleModel;
    @ApiModelProperty("材质")
    private String sampleMaterial;
    @ApiModelProperty("取样部位描述")
    private String sampleDesc;
    @ApiModelProperty("测试项目")
    private String testItem;
    @ApiModelProperty("测试方法")
    private String testItemMethod;
    @ApiModelProperty("测试条件")
    private String testItemCase;
    @ApiModelProperty("备注")
    private String remark;

}
