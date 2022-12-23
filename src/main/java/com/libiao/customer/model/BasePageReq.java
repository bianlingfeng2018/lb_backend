package com.libiao.customer.model;

import lombok.Data;

@Data
public class BasePageReq extends BaseSessionReq{

    private int page = 1;

    private int pageSize = 10;
}
