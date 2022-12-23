package com.libiao.customer.entity.req;

import lombok.Data;
import lombok.NonNull;

@Data
public class BillOutAddReq {
    @NonNull
    Integer id;
    String clientId;
    String tradeId;
    String operAmount;
}
