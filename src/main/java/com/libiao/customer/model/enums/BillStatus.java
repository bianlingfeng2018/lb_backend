package com.libiao.customer.model.enums;

import lombok.Data;

public enum BillStatus {

    BILL_INCOME("0"),//入账
    BILL_OUT("1"),//核销

    STATUS_SETTLED("1") ,//未核销
    STATUS_UNSETTLE("0") ,//已核销

    ;

    private  String value;
    BillStatus(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
