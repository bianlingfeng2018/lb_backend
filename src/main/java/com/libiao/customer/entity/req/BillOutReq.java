package com.libiao.customer.entity.req;

import lombok.Data;

import java.util.Date;

@Data
public class BillOutReq extends PageReq {
    String clientId;
    Date startTime;
    Date endTime;
    Date lastStartTime;
    Date lastEndTime;
    String status;

}
