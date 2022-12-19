package com.libiao.customer.util;


import com.libiao.customer.entity.AccessToken;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;


public class AccessTokenCacheUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(AccessTokenCacheUtil.class);


    public static final String USER_TOKEN_PREFIX = "USER_TOKEN";

    /**
     * 用户登录成功后往redis里面存储token
     */
    public static String putToken(AccessToken accessToken) {
        StringRedisTemplate stringRedisTemplate = SpringBeanUtil.getBean(StringRedisTemplate.class);
        String token = accessToken.getToken();
        try {
            stringRedisTemplate.opsForValue().set(createRedisKey(accessToken.getUsername()), token, 2, TimeUnit.HOURS);
        } catch (Exception e) {
            LOGGER.error("token save fail", e);
        }
        LOGGER.debug("token save success");
        return token;
    }

    /**
     * 获取redis中的用户token
     */
    public static String getToken(AccessToken accessToken) {
        StringRedisTemplate stringRedisTemplate = SpringBeanUtil.getBean(StringRedisTemplate.class);
        return stringRedisTemplate.opsForValue().get(createRedisKey(accessToken.getUsername()));
    }

    /**
     * 移除redis中token的值
     */
    public static void removeToken(AccessToken accessToken) {
        StringRedisTemplate stringRedisTemplate = SpringBeanUtil.getBean(StringRedisTemplate.class);
        stringRedisTemplate.delete(createRedisKey(accessToken.getUsername()));
    }

    public static String createRedisKey(String suffix) {
        return USER_TOKEN_PREFIX + ":" + suffix;
    }
}