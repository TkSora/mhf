package com.mhf.common.api.apiinteractive.domain;



/*****************************************************************************/

import com.mhf.common.business.domain.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Transient;

/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.apiinteractive.domain<br/>
 * File Name:RequestModel.java<br/>
 * 
 * 作成日 ：2017-8-10 上午9:37:35 <br/>
 * 
 * @author ：junkai.zhang
 */
//@Entity(name = "TCApiInteractiveDetail")
//@Table(name = "T_C_API_INTERACTIVE_DETAIL")
public class TCApiInteractiveDetail extends BaseEntity {

	@Transient
	private static final ThreadLocal<TCApiInteractiveDetail> API_INTERACTIVE_DETAIL_THREAD = new ThreadLocal<TCApiInteractiveDetail>();

	public static TCApiInteractiveDetail get() {
		return API_INTERACTIVE_DETAIL_THREAD.get();
	}

	public static void set(TCApiInteractiveDetail detail) {
		API_INTERACTIVE_DETAIL_THREAD.set(detail);
	}

	public static void remove() {
		API_INTERACTIVE_DETAIL_THREAD.remove();
	}

	private String userCode;

	private Integer lang;

	private String source;

	private String realIp;

	private Long beginTime;

	private Long endTime;

	private Long intervalTime;

	@Column(columnDefinition = "text")
	private String uri;

	@Column(columnDefinition = "text")
	private String requestBody;

	private String code;

	@Column(columnDefinition = "mediumtext")
	private String responseBody;

	@Column(columnDefinition = "mediumtext")
	private String errorMessage;

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public Integer getLang() {
		return lang;
	}

	public void setLang(Integer lang) {
		this.lang = lang;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRealIp() {
		return realIp;
	}

	public void setRealIp(String realIp) {
		this.realIp = realIp;
	}

	public Long getBeginTime() {
		return beginTime;
	}

	public void setBeginTime(Long beginTime) {
		this.beginTime = beginTime;
	}

	public Long getEndTime() {
		return endTime;
	}

	public void setEndTime(Long endTime) {
		this.endTime = endTime;
	}

	public Long getIntervalTime() {
		return intervalTime;
	}

	public void setIntervalTime(Long intervalTime) {
		this.intervalTime = intervalTime;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getRequestBody() {
		return requestBody;
	}

	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getResponseBody() {
		return responseBody;
	}

	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
