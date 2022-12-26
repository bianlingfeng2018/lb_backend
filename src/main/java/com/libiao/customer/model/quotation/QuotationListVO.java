package com.libiao.customer.model.quotation;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class QuotationListVO {

    @ApiModelProperty("报价单编号")
    private String quotationNum;
    @ApiModelProperty("客户中文名称")
    private String clientName;
    @ApiModelProperty("检测交易名称")
    private String tradeName;
    @ApiModelProperty("总金额")
    private Integer totalCost;
    @ApiModelProperty("已付金额")
    private Integer paidAmt;
    @ApiModelProperty("状态")
    private Byte state;
    @ApiModelProperty("进度")
    private Byte step;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty("报价日期")
    private Date gmtCreate;

}
