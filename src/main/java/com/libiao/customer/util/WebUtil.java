package com.libiao.customer.util;

import com.libiao.customer.entity.AccessToken;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @author Wang Xu
 * @date 2022/6/28
 */
public class WebUtil {
    /**
     * 需要在APP启动时候初始化这个值
     */
    public static String APP_ROOT_PATH = "";
    public static ThreadLocal<AccessToken> TOKEN_THREAD_POOL = new ThreadLocal<AccessToken>();

    public static String getRootUrl() {
        HttpServletRequest request = getRequest();
        if (Objects.isNull(request)) {
            return null;
        }
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

    public static void putAccessToken(AccessToken token) {
        TOKEN_THREAD_POOL.set(token);
    }

    public static AccessToken getAccessToken() {
        return TOKEN_THREAD_POOL.get();
    }

    public static void removeAccessToken() {
        TOKEN_THREAD_POOL.remove();
    }

    /**
     * 获取客户端IP
     */
    public static String getClientIp() {
        HttpServletRequest request = getRequest();
        if (request == null) {
            return "";
        }
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }

        //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ip != null && ip.indexOf(",") > 0) {
            ip = ip.substring(0, ip.indexOf(","));

        }

        return ip;
    }

    /**
     * 获取request对象
     */
    public static HttpServletRequest getRequest() {
        if (RequestContextHolder.getRequestAttributes() == null) {
            return null;
        } else {
            return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        }
    }

    /**
     * 获取request里面的参数
     */
    public static String getParameter(String name) {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getParameter(name);
        } else {
            return null;
        }
    }

    /**
     * 获取Http header的参数
     */
    public static String getHeaderParam(String name) {
        HttpServletRequest request = getRequest();
        if (request != null) {
            return request.getHeader(name);
        } else {
            return null;
        }
    }

}