package com.neunzwei.common.api.jsonwebtoken.biz.impl;

import com.neunzwei.common.api.jsonwebtoken.biz.IJSONWebTokenService;
import com.neunzwei.common.api.jsonwebtoken.domain.JSONWebToken;
import com.neunzwei.common.api.jsonwebtoken.util.JSONWebTokenUtil;
import com.neunzwei.common.business.biz.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
// @Transactional(value = TransactionConstant.OL, propagation =
// Propagation.REQUIRED)
public class JSONWebTokenServiceImpl extends BusinessServiceImpl implements IJSONWebTokenService {

	@Autowired
	private JSONWebTokenUtil util;

	public String getJWTString(JSONWebToken jsonWebToken) {
		return util.getJWTString(jsonWebToken);
	}

	public void isValid(JSONWebToken jsonWebToken) {
		util.isValid(jsonWebToken);
	}

}
