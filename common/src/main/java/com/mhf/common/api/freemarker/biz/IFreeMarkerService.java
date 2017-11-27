package com.mhf.common.api.freemarker.biz;

import java.util.Map;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.onlineleasing.shop.biz<br/>
 * File Name:ITOLShopService.java<br/>
 * 
 * 作成日 ：2017-5-18 下午4:34:06 <br/>
 * 
 * @author ：junkai.zhang
 */
public interface IFreeMarkerService {

	/**
	 * 
	 * getFreeMarkerTemplate:生成freemarker模板
	 * 
	 * @author junkai.zhang
	 * @param prefix
	 * @param templateName
	 * @param params
	 * @return
	 */
	public String getFreeMarkerTemplate(String prefix, String templateName, Map<String, Object> params);
}
