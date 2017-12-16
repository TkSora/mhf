package com.neunzwei.common.api.apiinteractive.handler;

import com.alibaba.fastjson.JSON;
import com.neunzwei.common.api.apiinteractive.domain.TCApiInteractiveDetail;
import com.neunzwei.common.base.entity.JsonContainer;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ApiInteractiveResponseBodyHandler implements ResponseBodyAdvice {


	@Override
	public boolean supports(MethodParameter returnType, Class converterType) {
		return true;
	}

	@Override
	public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

		// 返回jsonContainer
		if (body instanceof JsonContainer) {
			TCApiInteractiveDetail detail = TCApiInteractiveDetail.get();
			JsonContainer jsonContainer = (JsonContainer) body;
			if (null != jsonContainer) {
				detail.setCode(jsonContainer.getCode());
				detail.setResponseBody(JSON.toJSONString(body));
			}
			//System.out.println("i am in JsonContainer");
 		}
 		// 返回其他
 		else {
			//System.out.println("i am in else");
		}
		return body;
	}
}
