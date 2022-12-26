package com.libiao.customer.model.quotation;

import lombok.Data;

import java.util.List;

@Data
public class CreateQuotaGoodsReqVO {

    private Long goodsId;
    private Integer testPeriod;
    private Integer testPrice;
    private List<Integer> reportTypes;
    private List<QuotaGoodsItemVO> items;

}
