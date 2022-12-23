package com.libiao.customer.entity.req;

import lombok.Data;

import java.util.Date;

@Data
public class BillIncomeReq extends PageReq{
    Integer id;
    String clientId;
    Date startTime;
    Date endTime;
    String operType;


}
