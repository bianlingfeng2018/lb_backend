package com.libiao.customer.interceptor;

import com.alibaba.fastjson.JSON;
import com.libiao.customer.entity.AccessToken;
import com.libiao.customer.util.AccessTokenCacheUtil;
import com.libiao.customer.util.ResponseUtil;
import com.libiao.customer.util.WebUtil;
import com.libiao.customer.util.des.JwtUtil;
import com.libiao.customer.util.exception.ErrorCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * 认证校验拦截器
 */
@Slf4j
public class TokenAuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
		String token = request.getHeader("token");
		String servletPath = request.getServletPath();

		if (StringUtils.isNotBlank(servletPath) && servletPath.contains("/api/login/account")){
			return true;
		}
        log.info(">>>>>>>>> 用户认证，token is: {}", token);
		try {
			if (!(handler instanceof HandlerMethod)) {
				return true;
			}
			if (StringUtils.isBlank(token)) {
                buildNeedLoginResponse(request, response, handler);
                return false;
            }
			// 解析jwt, 存用户信息
            AccessToken accessToken = parseJwt(token);

            log.info(">>>>>>>>>>> origin request URL：{}, token auth accessToken= {}", request.getRequestURI(), accessToken);
            if (Objects.isNull(accessToken)) {
                buildNeedLoginResponse(request, response, handler);
                return false;
            }

			String redisToken = AccessTokenCacheUtil.getToken(accessToken);
            log.info(">>>>>>>>>>> token auth redisToken={}", redisToken);

			if (StringUtils.isBlank(redisToken)
//                    || !accessToken.getToken().equals(redisToken)
                    || !match(token, redisToken)) {
				buildNeedLoginResponse(request, response, handler);
				return false;
			}
            WebUtil.removeAccessToken();
            WebUtil.putAccessToken(accessToken);
			// 刷新token 缓存
            AccessTokenCacheUtil.putToken(accessToken);
            log.info(request.getRequestURI() + accessToken.toString());
			return true;
		} catch (Exception e) {
            log.error("认证异常， msg is：{}", e.toString(), e);
            if (Objects.nonNull(WebUtil.getAccessToken())) {
                log.info("preHandle removeAccessToken, username is: {}", WebUtil.getAccessToken().getUsername());
                WebUtil.removeAccessToken();
            }
			try {
				buildNeedLoginResponse(request, response, handler);
			} catch (IOException e1) {
                log.error("构建失败认证响应体异常，msg is：{}", e1.toString(), e1);
			}
			return false;
		}

	}

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("afterCompletion removeAccessToken, username is: {}", Objects.nonNull(WebUtil.getAccessToken())
                ? WebUtil.getAccessToken().getUsername()
                : " null ");
        if (Objects.nonNull(WebUtil.getAccessToken())) {
            log.info("postHandle removeAccessToken, username is: {}", WebUtil.getAccessToken().getUsername());
            WebUtil.removeAccessToken();
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        if (Objects.nonNull(WebUtil.getAccessToken())) {
            log.info("afterCompletion removeAccessToken, username is: {}", WebUtil.getAccessToken().getUsername());
            WebUtil.removeAccessToken();
        }
    }

    private AccessToken parseJwt(String webToken) {
        AccessToken accessToken = new AccessToken();
        accessToken.setToken(webToken);
        try {
            Map<String, String> userInfo = JwtUtil.verifyToken(webToken);
            accessToken.setUsername(userInfo.get("username"));
			accessToken.setPermission(userInfo.get("permission"));
        } catch (Exception e) {
            log.error("jwt token 解析异常， msg is：{}", e.toString(), e);
            return null;
        }
        return accessToken;
    }

	private boolean match(String webToken, String redisToken) {
        return redisToken.equals(webToken);
    }

	private void buildNeedLoginResponse(HttpServletRequest request
            , HttpServletResponse response, Object handler) throws IOException {
        CrossOrigin cros = getCros(handler);
        if (cros != null) {
            String allowCredentials = cros.allowCredentials();
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, StringUtils.isBlank(allowCredentials)
                    ? String.valueOf(CrossOrigin.DEFAULT_ALLOW_CREDENTIALS)
                    : allowCredentials);

            response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, String.valueOf(cros.maxAge()));

            String[] origins = cros.origins();
            StringBuilder originBuilder = new StringBuilder();
            if (origins.length == 0) {
                originBuilder.append(request.getHeader(HttpHeaders.ORIGIN));
            } else {
                for (int i = 0; i < origins.length; i++) {
                    if (i > 0) {
                        originBuilder.append(",");
                    }
                    originBuilder.append(origins[i]);
                }
            }
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, originBuilder.toString());

            RequestMethod[] methods = cros.methods();
            StringBuilder methodsBuilder = new StringBuilder();
            if (methods.length == 0) {
                HandlerMethod handlerMethod = (HandlerMethod) handler;
                RequestMapping requestMapping = handlerMethod.getMethodAnnotation(RequestMapping.class);
                methods = requestMapping.method();
            }
            for (int i = 0; i < methods.length; i++) {
                if (i > 0) {
                    methodsBuilder.append(",");
                }
                methodsBuilder.append(methods[i].name());
            }
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, methodsBuilder.toString());
        }

        response.setHeader("Content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(JSON.toJSONString(ResponseUtil.error(ErrorCodeEnum.INVALID_VOUCHER)));
	}

    private CrossOrigin getCros(Object handler) {
        if (!(handler instanceof HandlerMethod)) {
            return null;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        CrossOrigin annotation = handlerMethod.getMethodAnnotation(CrossOrigin.class);
        Class<?> clazz = null;
        int i = 0;
        while (annotation == null) {
            if (i == 0) {
                i++;
                clazz = handlerMethod.getBean().getClass();
            } else {
                clazz = clazz.getSuperclass();
            }
            if (clazz == null) {
                return null;
            }
            annotation = clazz.getAnnotation(CrossOrigin.class);
        }
        return annotation;
    }

}
