package com.mhf.common.api.apiinteractive.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import com.alibaba.fastjson.JSON;
import com.sbm.module.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.sbm.module.common.base.domain.JsonContainer;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.apiinteractive.advice<br/>
 * File Name:ResponseBodyAdvice.java<br/>
 * 
 * 作成日 ：2017-8-10 上午9:45:10 <br/>
 * 
 * @author ：junkai.zhang
 */
@ControllerAdvice
public class ApiInteractiveResponseBodyHandler implements ResponseBodyAdvice<JsonContainer> {

	public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
		return true;

	}

	public JsonContainer beforeBodyWrite(JsonContainer body, MethodParameter returnType, MediaType selectedContentType,
			Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
			ServerHttpResponse response) {

		TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
		if (null != body) {
			detail.setCode(body.getCode());
			detail.setResponseBody(JSON.toJSONString(body));
		}

		return body;
	}

}
