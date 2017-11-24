package com.mhf.common.base.pulisher.listener;

import com.mhf.common.base.constant.CommonConstant;
import com.mhf.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.mhf.common.base.pulisher.event.BusinessEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;

import java.text.MessageFormat;

public abstract class BusinessEventListener {

    @Autowired
    @Qualifier(BusinessEventListenerConstant.taskExecutor)
    private TaskExecutor taskExecutor;

    /**
     *
     * execute:执行任务
     *
     * @author junkai.zhang
     * @param event
     */
    protected abstract void execute(BusinessEvent event);

    /**
     *
     * async:异步
     *
     * @author junkai.zhang
     * @param event
     */
    // @Async(BusinessEventListenerConstant.taskExecutor)
    protected void async(final BusinessEvent event) {
        // 提高junit测试速度
        String s = System.getProperty("ASYNC_FLAG");
        if (StringUtils.isBlank(s) || Boolean.valueOf(s)) {
            taskExecutor.execute(new Runnable() {
                public void run() {
                    sync(event);
                }
            });
        } else {
            sync(event);
        }
    }

    protected void sync(final BusinessEvent event) {
        try {
            execute(event);
        } catch (Exception e) {
            // TODO 记录异常
//            CommonConstant.ERRORDATA.error(
//                    MessageFormat.format("{0} has an exception", this.getClass().getSimpleName()), e);
        }
        // System.out.println(Thread.currentThread().getName());
    }

}
