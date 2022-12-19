package com.libiao.customer.util.assertion;

public abstract class AssertionException extends RuntimeException{

    public abstract void setResultCode(AssertionResultCode resultCode);

    public AssertionException(){
        // 默认构造方法
    }

    public AssertionException(String msg){
        super(msg);
    }

    public AssertionException(Throwable cause){
        super(cause);
    }

    public AssertionException(String msg, Throwable cause){
        super(msg, cause);
    }


}
