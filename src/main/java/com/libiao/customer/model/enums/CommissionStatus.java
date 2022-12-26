package com.libiao.customer.model.enums;

public enum CommissionStatus {
    ACCEPT("Accept"),
    IN_APPROVE("inApprove"),
    REJECT("Reject")
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
