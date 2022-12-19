package com.libiao.customer.util.exception;

import com.libiao.customer.util.assertion.AssertionException;
import com.libiao.customer.util.assertion.AssertionResultCode;

public class LibiaoException extends AssertionException {

    public LibiaoException(ErrorCodeEnum errorCode) {
        this.errorCode = errorCode;
    }

    private ErrorCodeEnum errorCode;

    private ErrorContext errorContext;

    private String msg;

    public LibiaoException(){

    }

    public LibiaoException(String msg){
        this.msg = msg;
    }



    @Override
    public void setResultCode(AssertionResultCode resultCode) {

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
