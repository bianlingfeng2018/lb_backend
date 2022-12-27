package com.libiao.customer.interceptor;


import com.libiao.customer.entity.SessionUser;
import com.libiao.customer.util.ServletUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Set;

@Slf4j
public class SessionInterceptor implements HandlerInterceptor {

    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        HttpSession session = request.getSession();
        log.info("请求的URI:{},sessionId={}", request.getRequestURI(),session.getId());
        //log.info("请求的IP地址:{}", getIpAddress(request));
        session.setAttribute(SessionInfoEnum.IP.getName(), getIpAddress(request));
        SessionUser sessionUser = (SessionUser) session.getAttribute(SessionInfoEnum.USER.getName());
        if (sessionUser == null) {
            log.info("用户不存在，请登录");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            return false;
        }else {
            //唯一登录校验
            /*String key = "LOGIN_SESSION:" + sessionUser.getId();
            String sessionId = (String) redisTemplate.opsForValue().get(key);
            if (!session.getId().equals(sessionId)) {
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                return false;
            }*/

            //check rule
            /*Set<String> attribute = (Set<String>) session.getAttribute(SessionInfoEnum.RULES.getName());
            if (!CollectionUtils.isEmpty(attribute) && attribute.contains(ServletUtils.getPageUriCode(request))) {
                return true;
            }*/
            /*if (session.getRuleMap() != null && ssUser.getRuleMap().containsKey(pageUriCode)) {
                //如果在user的RuleMap里 则通过
                return true;
            }*/

        }
        return true;
    }

    public static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        if (StringUtils.hasLength(ip)) {
            log.info("getIpAddress(HttpServletRequest) - X-Forwarded-For - String ip=" + ip);
        }

        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                if (StringUtils.hasLength(ip)) {
                    log.info("getIpAddress(HttpServletRequest) - Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                if (StringUtils.hasLength(ip)) {
                    log.info("getIpAddress(HttpServletRequest) - WL-Proxy-Client-IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                if (StringUtils.hasLength(ip)) {
                    log.info("getIpAddress(HttpServletRequest) - HTTP_CLIENT_IP - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                if (StringUtils.hasLength(ip)) {
                    log.info("getIpAddress(HttpServletRequest) - HTTP_X_FORWARDED_FOR - String ip=" + ip);
                }
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                if (StringUtils.hasLength(ip)) {
                    log.info("getIpAddress(HttpServletRequest) - getRemoteAddr - String ip=" + ip);
                }
            }
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    break;
                }
            }
        }
        return ip;
    }
}
