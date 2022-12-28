package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class AddQuotationReq extends BaseSessionReq {

    @NotNull
    @ApiModelProperty("支付方式 0挂账 1~99 先付XX后检  100先付后检")
    private Byte payType;

    @ApiModelProperty("商品")
    private List<CreateQuotaGoodsReqVO> goods;

    @ApiModelProperty("报价单类型 1普通报价单 2加测报价单 3复测报价单")
    private Byte type;

    @ApiModelProperty("原始报价单号")
    private String orgQuotationNum;

    @Max(1)
    @Min(0)
    @ApiModelProperty("是否单独出报告 0否 1是")
    private Byte singleReport;
}
