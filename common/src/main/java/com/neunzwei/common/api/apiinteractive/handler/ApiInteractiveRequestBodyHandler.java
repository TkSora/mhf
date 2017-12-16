package com.neunzwei.common.api.apiinteractive.handler;

import com.alibaba.fastjson.JSON;
import com.neunzwei.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdvice;

import java.io.IOException;
import java.lang.reflect.Type;

@ControllerAdvice
public class ApiInteractiveRequestBodyHandler implements RequestBodyAdvice {

	public boolean supports(MethodParameter methodParameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {
		return true;
	}

	public Object handleEmptyBody(Object body, HttpInputMessage inputMessage, MethodParameter parameter,
			Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
		return body;
	}

	public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) throws IOException {
		return inputMessage;
	}

	public Object afterBodyRead(Object body, HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
			Class<? extends HttpMessageConverter<?>> converterType) {

		Object obj = body;
		// 实现处理接口的对象，执行相关操作
		if (body instanceof IApiInteractiveProcess) {
			obj = ((IApiInteractiveProcess) body).clone(body);
		}

		TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
		detail.setRequestBody(JSON.toJSONString(obj));

		return body;
	}

}
