package com.libiao.customer.model.enums;

public enum CommissionStatus {
    ACCEPT("审核通过"),
    IN_APPROVE("待审核"),
    REJECT("审核不通过")
    ;
    private  String name;
    CommissionStatus(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
