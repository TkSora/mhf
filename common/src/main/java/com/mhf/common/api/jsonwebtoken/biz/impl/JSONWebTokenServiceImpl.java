package com.mhf.common.api.jsonwebtoken.biz.impl;

import com.mhf.common.api.jsonwebtoken.biz.IJSONWebTokenService;
import com.mhf.common.api.jsonwebtoken.domain.JSONWebToken;
import com.mhf.common.api.jsonwebtoken.util.JSONWebTokenUtil;
import com.mhf.common.business.biz.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/
/**
 * Project Name:posUploadData<br/>
 * Package Name:com.sbm.module.postsales.biz.impl<br/>
 * File Name:EdiInteractiveDetailServiceImpl.java<br/>
 * 
 * 作成日 ：2016-1-4 下午5:05:55 <br/>
 * 
 * @author ：junkai.zhang 
 */
// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
/**
 * @preserve public
 */
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
