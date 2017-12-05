package com.mhf.common.api.mail.biz;

import com.mhf.common.api.mail.domain.MailData;

public interface IMailService {

	/**
	 * 
	 * sendMail:发送邮件
	 * 
	 * @author junkai.zhang
	 * @param mailData
	 */
	void sendMail(MailData mailData);
}
