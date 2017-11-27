package com.mhf.common.api.jsonwebtoken.biz;


/*****************************************************************************/

import com.mhf.common.api.jsonwebtoken.domain.JSONWebToken;

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IJSONWebTokenService {

	/**
	 * 
	 * getJWTString:获取token
	 * 
	 * @author junkai.zhang
	 * @param jsonWebToken
	 * @return
	 */
	public String getJWTString(JSONWebToken jsonWebToken);

	/**
	 * 
	 * isValid:校验
	 * 
	 * @author junkai.zhang
	 * @param jsonWebToken
	 */
	public void isValid(JSONWebToken jsonWebToken);

}
