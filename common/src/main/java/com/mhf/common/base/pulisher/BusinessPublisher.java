package com.mhf.common.base.pulisher;

import com.mhf.common.base.pulisher.event.BusinessEvent;
import com.mhf.common.base.util.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BusinessPublisher {

	@Autowired
	protected SpringBeanUtil util;

	private static final String pattern = "publishEvent : {0}";

	/**
	 * 
	 * publishEvent:发布事件
	 * 
	 * @author junkai.zhang
	 * @param event
	 */
	public void publishEvent(BusinessEvent event) {
		//CommonConstant.FRAMEWORK.info(MessageFormat.format(pattern, event.getClass().getSimpleName()));
		util.getApplicationContext().publishEvent(event);
	}
}
