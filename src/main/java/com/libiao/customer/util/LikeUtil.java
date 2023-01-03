package com.libiao.customer.util;

public class LikeUtil {

    public static String totalLike(String str){
        if(str == null){
            return null;
        }
        return "%" + str + "%";
    }

    public static String frontLike(String str){
        return "%" + str;
    }

    public static String backLike(String str){
        return str + "%";
    }
}
