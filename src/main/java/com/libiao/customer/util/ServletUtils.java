package com.libiao.customer.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Slf4j
public class ServletUtils {

    public static HttpSession getSession(){
        HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
        return session;
    }

    public static String getPath(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getRequestURI();
    }

    public static HttpServletRequest getRequest(){
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    }

    /**
     * 取得请求功能的路径
     */
    public static String getPageUriCode(HttpServletRequest request) {
        String uri = request.getRequestURI().replaceAll("/+", "/");
        String contextPath = request.getContextPath();
        if ("/".equals(contextPath) || "".equals(contextPath)) {
            uri = uri.substring(1);
        } else {
            uri = uri.substring(contextPath.length() + 1);
        }

        int dotPos = uri.indexOf(".");
        if (dotPos != -1) {
            uri = uri.substring(0, dotPos);
        }
        return uri;
    }
}
