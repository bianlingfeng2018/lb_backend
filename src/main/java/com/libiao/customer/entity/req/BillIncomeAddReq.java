package com.libiao.customer.entity.req;

import lombok.Data;
import lombok.NonNull;

@Data
public class BillIncomeAddReq {
    String clientId;
    Long operAmount;
    String desc;
    @NonNull
    String operType;

    String operUser;
    
}
