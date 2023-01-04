package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel
public class AdditionalQuotationVO {

    @ApiModelProperty("报价单号")
    private String quotationNum;
    @ApiModelProperty("1加测 2复测")
    private Byte type;
    @ApiModelProperty("测试周期")
    private Integer testPeriod;
    @ApiModelProperty("价格")
    private Integer totalCost;
    @ApiModelProperty("样品数量")
    private String sampleNum;
    @ApiModelProperty("测试项目")
    private List<QuotaDetailItemVO> items;

}
