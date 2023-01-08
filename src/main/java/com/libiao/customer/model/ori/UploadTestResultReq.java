package com.libiao.customer.model.ori;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UploadTestResultReq extends BaseSessionReq {

    @ApiModelProperty("原始记录单")
    private Long oriRecordId;
    @ApiModelProperty("测试值 比如 20mg")
    private String testValue;
    @ApiModelProperty("测试结果 比如 合格")
    private String testResult;
    @ApiModelProperty("限值（原样传回）")
    private String limitValue;
    @ApiModelProperty("文件名称")
    private String fileName;
    @ApiModelProperty("测试分类")
    private String testLevel;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("测试子项目")
    private List<SubResultVO> subList;
}
