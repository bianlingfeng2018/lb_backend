package com.libiao.customer.model.quotation;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@ApiModel
public class QuotationListVO {

    @ApiModelProperty("报价单编号")
    private String quotationId;

    private String name;

    private Integer amount;

    private Integer paidAmt;

    private Integer state;

    private Date quoteDate;

    private Long quotePerson;

    private String customerName;

}
