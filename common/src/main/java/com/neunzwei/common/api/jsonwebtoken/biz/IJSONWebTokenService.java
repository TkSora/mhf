package com.neunzwei.common.api.jsonwebtoken.biz;

import com.neunzwei.common.api.jsonwebtoken.domain.JSONWebToken;

public interface IJSONWebTokenService {

	/**
	 * 
	 * getJWTString:获取token
	 * 
	 * @author junkai.zhang
	 * @param jsonWebToken
	 * @return
	 */
	String getJWTString(JSONWebToken jsonWebToken);

	/**
	 * 
	 * isValid:校验
	 * 
	 * @author junkai.zhang
	 * @param jsonWebToken
	 */
	void isValid(JSONWebToken jsonWebToken);

}
