package com.mhf.common.api.frequency.domain;

import com.mhf.common.api.redis.constant.RedisConstant;

public class FrequencyDetail {

	private String ip;

	private String uri;

	private Integer count = 0;

	private Long timeout;

	private Integer limit;

	public String getKey() {
		return ip + RedisConstant.UNDER_LINE + uri;
	}

	/************************************************************************/

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Long getTimeout() {
		return timeout;
	}

	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

}
