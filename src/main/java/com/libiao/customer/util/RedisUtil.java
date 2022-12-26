package com.libiao.customer.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 生成报价单编号
     * @param date
     * @return
     */
    public String getNo(String date){
        String key = "TODAY_QUOTA_NO"+":"+date;
        Long increment = redisTemplate.opsForValue().increment(key, 1);
        if (increment > 26000){
            throw new ServiceException(HttpStatus.BAD_GATEWAY,"序列生成失败");
        }
        //获取后三位编号
        long no = increment % 1000;
        String noStr = String.format("%03d",no);
        //获取前一位字母
        long alpha = (increment / 1000) + 65;
        char aChar = (char) alpha;
        return "LIT" + date + aChar + noStr;
    }
}
