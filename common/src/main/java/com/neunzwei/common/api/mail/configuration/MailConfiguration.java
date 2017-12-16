package com.neunzwei.common.api.mail.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.Properties;

/*****************************************************************************/
/**
 * Project Name:posUploadDataService<br/>
 * Package Name:com.sbm.module.common.configutation<br/>
 * File Name:PropertiesReaderConfiguration.java<br/>
 * 
 * 作成日 ：2016-4-21 上午10:38:07 <br/>
 * 
 * @author ：junkai.zhang
 */
//@Configuration
public class MailConfiguration {

	@Value("#{propertiesReader['mail.host']}")
	private String host;
	@Value("#{propertiesReader['mail.port']}")
	private String port;
	@Value("#{propertiesReader['mail.username']}")
	private String username;
	@Value("#{propertiesReader['mail.password']}")
	private String password;
	@Value("#{propertiesReader['mail.defaultEncoding']}")
	private String defaultEncoding;
	@Value("#{propertiesReader['mail.protocol']}")
	private String protocol;

	/**
	 * 
	 * javaMailSenderBean:邮件发送类
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	@Bean(name = "javaMailSender")
	public JavaMailSenderImpl javaMailSenderBean() {
		JavaMailSenderImpl bean = new JavaMailSenderImpl();
		bean.setHost(host);
		bean.setPort(Integer.valueOf(port));
		bean.setUsername(username);
		bean.setPassword(password);
		bean.setDefaultEncoding(defaultEncoding);
		bean.setProtocol(protocol);
		bean.setJavaMailProperties(getJavaMailProperties());
		return bean;
	}

	/**
	 * 
	 * getJavaMailProperties:javaMail配置文件
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	private Properties getJavaMailProperties() {
		Properties javaMailProperties = new Properties();
		javaMailProperties.setProperty("mail.smtp.auth", "true");
		//javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
		javaMailProperties.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		return javaMailProperties;
	}

	/***********************************************************************/

	@Value("#{propertiesReader['mail.task.corePoolSize']}")
	private String corePoolSize;

	@Value("#{propertiesReader['mail.task.maxPoolSize']}")
	private String maxPoolSize;

	/**
	 * 
	 * taskExecutor4mailBean:邮件线程池
	 * 
	 * @author junkai.zhang
	 * @return
	 */
	@Bean(name = "taskExecutor4mail")
	public ThreadPoolTaskExecutor taskExecutor4mailBean() {
		ThreadPoolTaskExecutor bean = new ThreadPoolTaskExecutor();
		bean.setCorePoolSize(Integer.valueOf(corePoolSize));
		bean.setMaxPoolSize(Integer.valueOf(maxPoolSize));
		return bean;
	}

}
