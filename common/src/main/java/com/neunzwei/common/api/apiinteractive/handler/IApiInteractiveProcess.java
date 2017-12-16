package com.neunzwei.common.api.apiinteractive.handler;

public interface IApiInteractiveProcess {

	/**
	 * 
	 * clone:如果在记录对象的时候有敏感信息，复制对象并修改
	 * 
	 * @author junkai.zhang
	 * @param body
	 * @return
	 */
	public Object clone(Object body);

}
