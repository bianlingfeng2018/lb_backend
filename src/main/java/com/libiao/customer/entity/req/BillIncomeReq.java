package com.libiao.customer.entity.req;

import lombok.Data;

@Data
public class BillIncomeReq {
    Integer id;
    String clientId;
    String startTime;
    String endTime;
    String operType;

}
