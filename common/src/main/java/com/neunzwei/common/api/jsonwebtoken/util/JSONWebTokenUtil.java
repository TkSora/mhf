package com.neunzwei.common.api.jsonwebtoken.util;

import com.neunzwei.common.api.jsonwebtoken.constant.JSONWebTokenConstant;
import com.neunzwei.common.api.jsonwebtoken.domain.JSONWebToken;
import com.neunzwei.common.base.constant.BusinessCode;
import com.neunzwei.common.base.exception.BusinessException;
import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JSONWebTokenUtil {

	// 版本
	public static String TOKEN_VERSION = "1";
	// 设置发行人
	public static String ISSUER = "superbrandmall";
	// 设置抽象主题
	public static String SUBJECT = "OnlineLeasing";
	// HS256 私钥
	public static String HS256KEY = "OL_SBM_p@ssw0rd";
	// 加密方式
	public static SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
	// Time To Live
	// 12小时
	public static long TTL = 12 * 60 * 60 * 1000L;

	public static Key signingKey = new SecretKeySpec(Base64.decodeBase64(HS256KEY), signatureAlgorithm.getJcaName());

	/**
	 * 
	 * getJWTString:获取token
	 * 
	 * @author junkai.zhang
	 * @param jsonWebToken
	 * @return
	 */
	public String getJWTString(JSONWebToken jsonWebToken) {
		Long now = System.currentTimeMillis();
		Long exp = now + TTL;

		jsonWebToken.getClaims().put(Claims.ID, TOKEN_VERSION);
		jsonWebToken.getClaims().put(Claims.ISSUER, ISSUER);
		jsonWebToken.getClaims().put(Claims.SUBJECT, SUBJECT);
		jsonWebToken.getClaims().put(Claims.AUDIENCE, jsonWebToken.getLogin());
		jsonWebToken.getClaims().put(Claims.ISSUED_AT, new Date(now));
		jsonWebToken.getClaims().put(Claims.EXPIRATION, new Date(exp));

		// 加入用户类型
		jsonWebToken.getClaims().put(JSONWebTokenConstant.TYPE, jsonWebToken.getType());

		JwtBuilder jwtBuilder = Jwts.builder().setHeaderParam(Header.TYPE, Header.JWT_TYPE)
				.setClaims(jsonWebToken.getClaims()).signWith(signatureAlgorithm, signingKey);
		return jwtBuilder.compact();
	}

	/**
	 * 
	 * parseJWTString:转换token
	 * 
	 * @author junkai.zhang
	 * @param token
	 * @return
	 */
	public Jws<Claims> parseJWTString(String token) {
		Jws<Claims> jwsClaims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token.trim());
		return jwsClaims;
	}

	/**
	 * 
	 * isValid:校验
	 * 
	 * @author junkai.zhang
	 * @param jsonWebToken
	 * @return
	 */
	public boolean isValid(JSONWebToken jsonWebToken) {
		// 用户login不能为空
		if (StringUtils.isBlank(jsonWebToken.getLogin())) {
			throw new BusinessException(BusinessCode.C0004, null);
		}
		// 用户token不能为空
		if (StringUtils.isBlank(jsonWebToken.getToken())) {
			throw new BusinessException(BusinessCode.C0003, null);
		}
		Jws<Claims> jwsClaims;
		try {
			jwsClaims = parseJWTString(jsonWebToken.getToken());
		} catch (Exception e) {
			// 解析异常
			throw new BusinessException(BusinessCode.C0001, e);
		}

		// 用户login和token不匹配
		if (!jsonWebToken.getLogin().equals(jwsClaims.getBody().getAudience())) {
			throw new BusinessException(BusinessCode.C0005, null);
		}

		// TODO 暂时去除
//		// 用户类型不匹配
//		if (jsonWebToken.getType() != (int)(jwsClaims.getBody().get(JSONWebTokenConstant.TYPE))) {
//			throw new BusinessException(BusinessCode.C0006, null);
//		}

		if (null != jwsClaims) {
			Long exp = (Long) jwsClaims.getBody().get(Claims.EXPIRATION);
			Long now = System.currentTimeMillis();
			// 超时
			if (exp < now) {
				throw new BusinessException(BusinessCode.C0002, null);
			}
		}

		return true;
	}

}
