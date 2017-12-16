package com.neunzwei.common.base.biz.impl;

import com.neunzwei.common.base.biz.ICommonService;
import com.neunzwei.common.base.pulisher.BusinessPublisher;
import com.neunzwei.common.base.pulisher.event.BusinessEvent;
import com.neunzwei.common.base.util.CloneUtil;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;


/*****************************************************************************/
/**
 * Project Name:upload2luis<br/>
 * Package Name:com.sbm.module.common.biz.impl<br/>
 * File Name:CommonServiceImpl.java<br/>
 * 
 * 作成日 ：2017-4-7 下午4:17:11 <br/>
 * 
 * @author ：junkai.zhang
 */
public class CommonServiceImpl implements ICommonService {

	/**
	 * 消息发布
	 */
	@Autowired
	protected BusinessPublisher publisher;

	/**
	 * 
	 * publishEvent:发布消息
	 * 
	 * @author junkai.zhang
	 * @param event
	 */
	protected void publishEvent(BusinessEvent event) {
		publisher.publishEvent(event);
	}

	/**
	 * 
	 * getStackTrace:获取堆栈信息
	 * 
	 * @author junkai.zhang
	 * @param e
	 * @return
	 */
	protected String getStackTrace(Exception e) {
		return ExceptionUtils.getStackTrace(e);
	}

	/**
	 * 
	 * jsonClone:json序列化克隆
	 * 
	 * @author junkai.zhang
	 * @param t
	 * @param clazz
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	protected Object jsonClone(Object t, Class clazz) {
		return CloneUtil.jsonClone(t, clazz);
	}

	/**
	 * 
	 * getUUID:生成随机的uuid
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	protected String getUUID() {
		return UUID.randomUUID().toString();
	}

}
