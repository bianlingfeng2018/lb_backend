package com.libiao.customer.config;

import com.alibaba.fastjson.JSONObject;
import com.libiao.customer.entity.SessionUser;
import com.libiao.customer.interceptor.SessionInfoEnum;
import com.libiao.customer.model.BaseRequest;
import com.libiao.customer.model.BaseSessionReq;
import com.libiao.customer.model.ErrorMessage;
import com.libiao.customer.util.*;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Set;

/**
 * controller切面，做一些处理
 *
 */
@Component
@Aspect
@Slf4j
public class ControllerAspect {



	// 环绕切面
	@Around("execution(* com.libiao.customer.controller..*(..))")
	public Object process(ProceedingJoinPoint point) {
		log.info("切入目标方法：{}.{}", point.getSignature().getDeclaringTypeName(), point.getSignature().getName());
		//获取session
		final HttpSession session = ServletUtils.getSession();
		Object[] args = point.getArgs();
		MethodSignature methodSignature = (MethodSignature) point.getSignature();
		String URI = ServletUtils.getPath();

		/*final AccessController accessController = methodSignature.getMethod().getAnnotation(AccessController.class);
		if(accessController == null){
			//去校验权限
			if(!checkRule(session,URI)){
				log.info("权限认证失败");
				return ResponseUtil.convert(ErrorMessage.FORBIDDEN);
			}
		}else if (accessController.isValidate()){
			//去校验权限，（即没有映射配置，也没有本身配置）
			if (!checkRule(session, accessController.mappingPath()) && !checkRule(session, URI)) {
				log.info("权限认证失败");
				return ResponseUtil.convert(ErrorMessage.FORBIDDEN);
			}
		}*/

		for (Object arg : args) {
			if (arg != null && BaseRequest.class.isAssignableFrom(arg.getClass())) {
				MDC.put("traceNo",((BaseRequest) arg).getRequestId());
				log.info("切入目标方法参数:{}", JSONObject.toJSONString(arg));
				//校验参数
				String errMsg = ValidationUtil.validate(arg);
				if (errMsg != null) {
					return ResponseUtil.convert(ErrorMessage.INVALIDATE_PARAM.getStatus(), errMsg);
				}
				if (BaseSessionReq.class.isAssignableFrom(arg.getClass())) {
					SessionUser sessionUser = (SessionUser) (session.getAttribute(SessionInfoEnum.USER.getName()));
					((BaseSessionReq) arg).setUser(sessionUser);
				}
				break;
			}
		}
		try {
			Object retVal = point.proceed(args);
			log.info("返回结果{}", JSONObject.toJSONString(retVal));
			return retVal;
		} catch (ServiceException e) {
			log.info("业务异常抛出{}", e.getMessage());
			return ResponseUtil.convert(e.getStatus(), e.getMessage());
		} catch (Throwable e) {
			log.error("系统异常！", e);
			return ResponseUtil.convert(ErrorMessage.SYSTEM_ERROR);
		}
	}

	public boolean checkRule(HttpSession session, String URI) {
		final Set<String> rules = (Set<String>) session.getAttribute(SessionInfoEnum.RULES.getName());
		return rules.contains(URI);
	}

	public boolean checkRule(HttpSession session, String[] paths) {
		final Set<String> rules = (Set<String>) session.getAttribute(SessionInfoEnum.RULES.getName());
		for (String path : paths) {
			if (rules.contains(path)) {
				return true;
			}
		}
		return false;
	}


}
