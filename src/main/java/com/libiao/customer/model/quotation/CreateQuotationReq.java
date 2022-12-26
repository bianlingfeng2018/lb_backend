package com.libiao.customer.model.quotation;

import com.libiao.customer.model.BaseSessionReq;
import lombok.Data;

@Data
public class CreateQuotationReq extends BaseSessionReq {


    private String quotationNum;
}
