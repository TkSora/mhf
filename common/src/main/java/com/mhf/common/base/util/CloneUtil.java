package com.mhf.common.base.util;

import com.alibaba.fastjson.JSON;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.util<br/>
 * File Name:ListUtil.java<br/>
 * 
 * 作成日 ：2017-8-7 下午5:32:00 <br/>
 * 
 * @author ：junkai.zhang
 */
public class CloneUtil {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static Object jsonClone(Object t, Class clazz) {
		Object obj = JSON.parseObject(JSON.toJSONString(t), clazz);
		return obj;
	}

}
