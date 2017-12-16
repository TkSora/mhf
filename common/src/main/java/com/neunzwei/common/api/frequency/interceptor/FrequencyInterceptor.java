package com.neunzwei.common.api.frequency.interceptor;

import com.neunzwei.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.neunzwei.common.api.frequency.annotation.Frequency;
import com.neunzwei.common.api.frequency.biz.IFrequencyService;
import com.neunzwei.common.api.frequency.domain.FrequencyDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("frequencyInterceptor")
public class FrequencyInterceptor implements HandlerInterceptor {

	@Autowired
	private IFrequencyService service;

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			// 判断方法上是否有
			Frequency frequency = ((HandlerMethod) handler).getMethodAnnotation(Frequency.class);
			// 如果方法上没有，判断类上是否有
			if (null == frequency) {
				frequency = ((HandlerMethod) handler).getBeanType().getAnnotation(Frequency.class);
			}
			// 存在时校验
			if (null != frequency) {
				// 从本地线程取
				TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
				// 创建对象
				FrequencyDetail obj = new FrequencyDetail();
				obj.setIp(detail.getRealIp());
				obj.setUri(detail.getUri());
				obj.setTimeout(frequency.timeout());
				obj.setLimit(frequency.limit());
				// 校验对象
				service.checkFrequencyDetail(obj);
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
