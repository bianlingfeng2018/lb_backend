package com.libiao.customer.dal.model;

import lombok.Data;

@Data
public class SplitInfo {

    private Long id;//company_id
    private String comName;//公司名
    private Byte subContract;//是否分包商0否 1是

    private String labName;
    private String deviceName;

    private Integer itemId;
    private Integer price;
    private Integer period;

}
