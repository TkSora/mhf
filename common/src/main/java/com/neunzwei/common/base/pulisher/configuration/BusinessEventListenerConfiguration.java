package com.neunzwei.common.base.pulisher.configuration;

import com.neunzwei.common.base.pulisher.constant.BusinessEventListenerConstant;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class BusinessEventListenerConfiguration {

//    @Value("#{propertiesReader['base.BusinessEventListenerConfiguration.corePoolSize']}")
//    private String corePoolSize;
//
//    @Value("#{propertiesReader['base.BusinessEventListenerConfiguration.maxPoolSize']}")
//    private String maxPoolSize;

    /**
     *
     * taskExecutor:事件线程池
     *
     * @author junkai.zhang
     * @return
     */
    @Bean(name = BusinessEventListenerConstant.taskExecutor)
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor bean = new ThreadPoolTaskExecutor();
//        bean.setCorePoolSize(Integer.valueOf(corePoolSize));
//        bean.setMaxPoolSize(Integer.valueOf(maxPoolSize));
        bean.setCorePoolSize(10);
        bean.setMaxPoolSize(30);
        return bean;
    }
}
