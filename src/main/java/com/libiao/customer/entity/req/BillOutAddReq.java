package com.libiao.customer.entity.req;

import lombok.Data;
import lombok.NonNull;

@Data
public class BillOutAddReq {
    @NonNull
    Long id;
    String clientId;
    String tradeId;
    Long operAmount;
    String operUser;
}
