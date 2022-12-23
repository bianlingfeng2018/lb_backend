package com.libiao.customer.model;

import com.libiao.customer.entity.SessionUser;
import lombok.Data;

@Data
public class BaseSessionReq extends BaseRequest{

    private SessionUser user;

}
