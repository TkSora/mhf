package com.mhf.common.api.jsonwebtoken.domain;

import java.util.HashMap;
import java.util.Map;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.api.jsonwebtoken.domain<br/>
 * File Name:JSONWebToken.java<br/>
 * 
 * 作成日 ：2017-10-10 上午11:54:44 <br/>
 * 
 * @author ：junkai.zhang
 */
public class JSONWebToken {

	private String login;

	private int type;

	private String token;

	private Map<String, Object> claims;

	public JSONWebToken() {
		super();
	}

	public JSONWebToken(String login, int type) {
		this(login, type, null);
	}

	public JSONWebToken(String login, int type, String token) {
		this(login, type, token, new HashMap<String, Object>());
	}

	public JSONWebToken(String login, int type, String token, Map<String, Object> claims) {
		super();
		this.login = login;
		this.type = type;
		this.token = token;
		this.claims = claims;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Map<String, Object> getClaims() {
		return claims;
	}

	public void setClaims(Map<String, Object> claims) {
		this.claims = claims;
	}

}
