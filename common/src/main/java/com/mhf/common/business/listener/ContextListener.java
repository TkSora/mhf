package com.mhf.common.business.listener;

import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

@Component
public class ContextListener implements ServletContextListener {

	private static final String BASE = "base";

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		System.out.println("-------关闭中--------");
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		event.getServletContext().setAttribute(BASE, event.getServletContext().getContextPath());
		// TODO
		//System.setProperty("baseFilePath", ApplicationConstant.LOG);
		//System.setProperty("java.net.preferIPv4Stack", "true");
		System.out.println("-------启动中-------");
	}

}
