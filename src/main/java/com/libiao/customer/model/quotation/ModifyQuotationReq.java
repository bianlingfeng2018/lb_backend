package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseSessionReq;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class ModifyQuotationReq extends BaseSessionReq {

    @NotBlank
    @ApiModelProperty("报告单号")
    private String quotationNum;

    @NotBlank
    @ApiModelProperty("客户ID")
    private Integer clientId;
    @NotBlank
    @ApiModelProperty("客户名称")
    private String clientName;
    @NotBlank
    @ApiModelProperty("客户名称")
    private String clientNum;
    @NotBlank
    @ApiModelProperty("交易名称")
    private String tradeName;
    @ApiModelProperty("客户描述")
    private String tradeDesc;

    @NotNull
    @ApiModelProperty("支付方式 0挂账 1~99 先付XX后检  100先付后检")
    private Byte payType;

    @ApiModelProperty("客户联系人")
    private String attn;
    @ApiModelProperty("客户电话")
    private String telClient;
    @ApiModelProperty("客户传真")
    private String faxClient;
    @ApiModelProperty("邮箱")
    private String email;
    @NotBlank
    @ApiModelProperty("邮寄地址")
    private String deliveryAddress;

    @ApiModelProperty("总费用")
    private Integer totalCost;
    @ApiModelProperty("快递费")
    private Integer postage;
    @ApiModelProperty("报告费用")
    private Integer reportFee;

    @ApiModelProperty("商品")
    private List<CreateQuotaGoodsReqVO> goods;

    @ApiModelProperty("报价单类型 1普通报价单 2加测报价单 3复测报价单")
    private Byte type;
    @ApiModelProperty("当报价单类型不为1是，传入原报价单号")
    private Long oriId;
}
