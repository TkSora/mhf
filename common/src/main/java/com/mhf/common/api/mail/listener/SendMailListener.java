package com.mhf.common.api.mail.listener;

import com.mhf.common.api.mail.biz.IMailService;
import com.mhf.common.api.mail.domain.MailData;
import com.mhf.common.api.mail.event.ISendMailEvent;
import com.mhf.common.base.pulisher.constant.BusinessEventListenerConstant;
import com.mhf.common.base.pulisher.event.BusinessEvent;
import com.mhf.common.base.pulisher.listener.BusinessEventListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;



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
public class SendMailListener extends BusinessEventListener {

	//@Autowired
	private IMailService service;

	@EventListener
	public void onSendMailEvent(BusinessEvent event) {
		if (event instanceof ISendMailEvent) {
			async(event);
		}
	}

	protected void execute(BusinessEvent event) {
		if (event.isNotNull(BusinessEventListenerConstant.MAIL)) {
			MailData mailData = (MailData) event.getTemplate().get(BusinessEventListenerConstant.MAIL);
			service.sendMail(mailData);
		}
	}
}
