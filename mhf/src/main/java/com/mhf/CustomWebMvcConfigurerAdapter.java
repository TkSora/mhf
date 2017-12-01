package com.mhf;

import com.mhf.common.base.util.SpringBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CustomWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter{

    @Autowired
    private SpringBeanUtil util;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注意顺序
        // CORS跨域
        registry.addInterceptor((HandlerInterceptor) util.getBean("CORSInterceptor")).addPathPatterns("/**");
        // api监控
        registry.addInterceptor((HandlerInterceptor) util.getBean("apiInteractiveInterceptor")).addPathPatterns("/**");
        // 频率监控
        registry.addInterceptor((HandlerInterceptor) util.getBean("frequencyInterceptor")).addPathPatterns("/**");
        // jwt权限监控
        registry.addInterceptor((HandlerInterceptor) util.getBean("JSONWebTokenInterceptor")).addPathPatterns("/**");
    }

}
