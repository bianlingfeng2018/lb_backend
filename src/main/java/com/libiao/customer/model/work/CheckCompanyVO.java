package com.libiao.customer.model.work;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CheckCompanyVO {

    @ApiModelProperty("ID")
    private Long id;
    @ApiModelProperty("公司名称")
    private String comName;
    @ApiModelProperty("是否分包商 0否 1是")
    private Byte subContract;
    @ApiModelProperty("CNAS资质 0无 1有")
    private Byte cnas;
    @ApiModelProperty("CMA资质 0无 1有")
    private Byte cma;

}
