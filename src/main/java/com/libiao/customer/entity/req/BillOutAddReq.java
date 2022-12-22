package com.libiao.customer.entity.req;

import lombok.Data;
import lombok.NonNull;

@Data
public class BillOutAddReq {
    @NonNull
    String clientId;
    String operAmount;
    String desc;
    @NonNull
    String operType;
    
}
