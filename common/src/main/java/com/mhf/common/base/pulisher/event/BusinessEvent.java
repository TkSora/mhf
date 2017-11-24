package com.mhf.common.base.pulisher.event;

import com.mhf.common.base.pulisher.template.BusinessEventTemplate;
import org.springframework.context.ApplicationEvent;

public class BusinessEvent extends ApplicationEvent {

    private static final long serialVersionUID = 6559830334228453740L;

    public BusinessEvent(BusinessEventTemplate template) {
        super(template);
    }

    /**
     *
     * getTemplate:获取模板
     *
     * @author junkai.zhang
     * @return
     */
    public BusinessEventTemplate getTemplate() {
        return (BusinessEventTemplate) getSource();
    }

    /**
     *
     * isNotNull:判断非空
     *
     * @author junkai.zhang
     * @param keys
     * @return
     */
    public boolean isNotNull(String... keys) {
        boolean b = true;
        for (String key : keys) {
            if (null == this.getTemplate().get(key)) {
                b = false;
//                CommonConstant.FRAMEWORK.warn(MessageFormat.format("{0} is null", key));
            }
        }
        return b;
    }
}
