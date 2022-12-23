package com.libiao.customer.model;

import org.springframework.http.HttpStatus;

public enum ErrorMessage {

    SYSTEM_ERROR(HttpStatus.SERVICE_UNAVAILABLE, "系统繁忙，请稍后再试"),
    COMMON_FAILED(HttpStatus.EXPECTATION_FAILED, "请求处理失败"),
    USER_NOTFOUND(HttpStatus.NOT_FOUND, "用户不存在"),
    INVALIDATE_PARAM(HttpStatus.BAD_REQUEST, "参数异常"),
    FORBIDDEN(HttpStatus.FORBIDDEN, "没有权限，禁止访问"),
    WRONG_PASSWORD(HttpStatus.NOT_ACCEPTABLE, "用户名或者密码错误"),
    METHOD_NOT_ALLOWED(HttpStatus.METHOD_NOT_ALLOWED, "禁止访问该方法"),
    TOO_MANY_REQUESTS(HttpStatus.TOO_MANY_REQUESTS, "访问频繁，请稍后再试"),
    ;
    private HttpStatus status;
    private String errMsg;

    ErrorMessage(HttpStatus status, String errMsg) {
        this.status = status;
        this.errMsg = errMsg;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getErrMsg() {
        return errMsg;
    }
}
