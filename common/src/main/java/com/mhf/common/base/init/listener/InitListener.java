package com.mhf.common.base.init.listener;

import com.mhf.common.base.init.InitAfterLoad;
import com.mhf.common.base.util.SpringBeanUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.Map;



/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.common.listener<br/>
 * File Name:InitListener.java<br/>
 * 
 * 作成日 ：2017-8-17 下午5:33:02 <br/>
 * 
 * @author ：junkai.zhang
 */
@Component
public class InitListener {

	@Autowired
	private SpringBeanUtil util;

	private static boolean isStart = false;

	@EventListener
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (!isStart) {
			isStart = true;
			// 提高junit测试速度
			String s = System.getProperty("INIT_FLAG");
			if (StringUtils.isBlank(s) || Boolean.valueOf(s)) {
				init();
			}
		}
	}

	private void init() {
		//CommonConstant.FRAMEWORK.info("InitListener: initialization started");
		long startTime = System.currentTimeMillis();
		Map<String, InitAfterLoad> map = util.getApplicationContext().getBeansOfType(InitAfterLoad.class);
		for (String key : map.keySet()) {
			//CommonConstant.FRAMEWORK.info(key + ": initialization started");
			long startTimeTmp = System.currentTimeMillis();
			// 执行
			map.get(key).init();
			long elapsedTimeTmp = System.currentTimeMillis() - startTimeTmp;
			//CommonConstant.FRAMEWORK.info(key + ": initialization completed in " + elapsedTimeTmp + " ms");
		}
		long elapsedTime = System.currentTimeMillis() - startTime;
		//CommonConstant.FRAMEWORK.info("InitListener: total initialization completed in " + elapsedTime + " ms");
	}
}
