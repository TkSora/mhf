package com.mhf.common.base.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringBeanUtil implements ApplicationContextAware{


    private ApplicationContext ctx = null;

    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        this.ctx = ctx;
    }

    public ApplicationContext getApplicationContext() {
        return ctx;
    }

    @SuppressWarnings("unchecked")
        public <T> T getBean(String prop) {
        Object obj = ctx.getBean(prop);
        return (T) obj;
    }
}
