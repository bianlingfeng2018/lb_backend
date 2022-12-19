package com.libiao.customer.util.exception;

import com.libiao.customer.util.assertion.AssertionResultCode;
import com.libiao.customer.util.error.ErrorLevels;
import com.libiao.customer.util.error.ErrorTypes;

public enum ErrorCodeEnum implements AssertionResultCode {


    UNKNOWN_ERROR("103", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "未知异常"),
    INVALID_VOUCHER("104", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "无效凭证"),
    NOT_FOUND("404", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "资源不存在"),
    UPLOAD_ERROR_NO_FILE("412", ErrorLevels.ERROR, ErrorTypes.SYSTEM, "没有文件被上传")
    ;

    private final String code;

    private final String level;

    private final String type;

    private final String description;

    @Override
    public String getResultCode() {
        return null;
    }

    @Override
    public String getResultMsg() {
        return null;
    }

    public String getCode() {
        return code;
    }


    public String getDescription() {
        return description;
    }

    private ErrorCodeEnum(String code, String level, String type, String description){
        this.code = code;
        this.level = level;
        this.type = type;
        this.description = description;
    }
}
