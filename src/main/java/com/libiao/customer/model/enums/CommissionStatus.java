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

    public static CommissionStatus parse(String name){
        if(ACCEPT.getName().equals(name)){
            return ACCEPT;
        }
        if(REJECT.getName().equals(name)){
            return REJECT;
        }
        return IN_APPROVE;
    }

}
