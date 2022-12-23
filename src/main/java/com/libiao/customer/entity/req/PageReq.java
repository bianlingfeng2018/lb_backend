package com.libiao.customer.entity.req;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
public class PageReq {
    @NonNull
    Integer pageNum;
    @NonNull
    Integer pageSize;

}
