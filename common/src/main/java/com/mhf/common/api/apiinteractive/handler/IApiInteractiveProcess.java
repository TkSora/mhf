package com.mhf.common.api.apiinteractive.handler;

/*****************************************************************************/
/**
 * Project Name:oldataservice<br/>
 * Package Name:com.sbm.module.common.api.apiinteractive.handler<br/>
 * File Name:IApiInteractiveProcess.java<br/>
 * 
 * 作成日 ：2017-9-4 下午1:10:19 <br/>
 * 
 * @author ：junkai.zhang
 */
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
