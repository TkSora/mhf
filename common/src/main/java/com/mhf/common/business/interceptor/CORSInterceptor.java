package com.mhf.common.business.interceptor;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.interceptor<br/>
 * File Name:JSONWebTokenInterceptor.java<br/>
 * 
 * 作成日 ：2017-8-2 上午10:59:52 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component("CORSInterceptor")
public class CORSInterceptor implements HandlerInterceptor {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (request.getHeader(HttpHeaders.ORIGIN) != null) {
			response.addHeader("Access-Control-Allow-Origin", "*");
			response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE, PUT, HEAD");
			response.addHeader("Access-Control-Allow-Headers", "Content-Type, Login, Authorization, Lang, Source");
			response.addHeader("Access-Control-Expose-Headers", "Content-Type, Login, Authorization, Lang, Source");
			response.addHeader("Access-Control-Max-Age", "3600");
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
