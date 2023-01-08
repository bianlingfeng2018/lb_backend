package com.libiao.customer.model.report;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ReportSampleDescVO {

    @ApiModelProperty("样品编号")
    private Long id;
    @ApiModelProperty("取样部位（位置）")
    private String sampleName;
    @ApiModelProperty("取样部位描述")
    private String sampleDescription;
}
