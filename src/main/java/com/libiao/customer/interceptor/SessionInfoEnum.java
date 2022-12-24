package com.libiao.customer.interceptor;

public enum SessionInfoEnum {

    USER("user"),
    IP("ip address"),
    RULES("rules"),
    CAPTCHA("captcha"),
    NEED_CAPTCHA("needCaptcha"),

    ;

    private String name;

    SessionInfoEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
