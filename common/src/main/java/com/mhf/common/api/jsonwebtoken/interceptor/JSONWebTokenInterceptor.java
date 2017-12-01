package com.mhf.common.api.jsonwebtoken.interceptor;

import com.mhf.common.api.jsonwebtoken.annotation.Authorization;
import com.mhf.common.api.jsonwebtoken.biz.IJSONWebTokenService;
import com.mhf.common.api.jsonwebtoken.constant.JSONWebTokenConstant;
import com.mhf.common.api.jsonwebtoken.domain.JSONWebToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("JSONWebTokenInterceptor")
public class JSONWebTokenInterceptor implements HandlerInterceptor {

	@Autowired
	private IJSONWebTokenService service;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 默认全部回传
		response.setHeader(JSONWebTokenConstant.LOGIN, request.getHeader(JSONWebTokenConstant.LOGIN));
		response.setHeader(JSONWebTokenConstant.AUTHORIZATION, request.getHeader(JSONWebTokenConstant.AUTHORIZATION));

		if (handler instanceof HandlerMethod) {
			// 判断方法上是否有
			Authorization authorization = ((HandlerMethod) handler).getMethodAnnotation(Authorization.class);
			// 如果方法上没有，判断类上是否有
			if (null == authorization) {
				authorization = ((HandlerMethod) handler).getBeanType().getAnnotation(Authorization.class);
			}

			// 声明，并且需要时才验证
			if (authorization != null && authorization.validate()) {
				int type = authorization.type();
				// 获取login
				String login = request.getHeader(JSONWebTokenConstant.LOGIN);
				// 获取token
				String token = request.getHeader(JSONWebTokenConstant.AUTHORIZATION);
				// 校验对象
				JSONWebToken jsonWebToken = new JSONWebToken(login, type, token);
				// 验证逻辑
				service.isValid(jsonWebToken);
				// 验证成功刷新token
				response.setHeader(JSONWebTokenConstant.AUTHORIZATION, service.getJWTString(jsonWebToken));
				// 回传login
				response.setHeader(JSONWebTokenConstant.LOGIN, login);
			}
		}
		return true;
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
