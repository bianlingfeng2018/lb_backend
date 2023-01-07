package com.libiao.customer.model.work;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CreateWorkOrderVO {

    @ApiModelProperty("检测公司ID")
    private Integer testComId;
    @ApiModelProperty("检测公司名称")
    private String comName;
    @ApiModelProperty("是否分包商 0否 1是")
    private Byte subContract;

    @ApiModelProperty("测试项列表")
    private List<CreateWorkOrderItemVO> testItemList;


}
