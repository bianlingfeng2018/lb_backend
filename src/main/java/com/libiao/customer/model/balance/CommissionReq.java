package com.libiao.customer.model.balance;

import com.libiao.customer.model.BaseSessionReq;
import lombok.Data;

@Data
public class CommissionReq extends BaseSessionReq {
    private Long id;

    private String clientId;

    private Integer rate;

    private String descp;
    private String status;
}
