package com.mhf.common.api.mail.domain;

import java.util.List;

/*****************************************************************************/
/**
 * Project Name:onlineleasing<br/>
 * Package Name:com.sbm.module.commonapi.mail.domain<br/>
 * File Name:MailData.java<br/>
 * 
 * 作成日 ：2017-8-3 下午2:11:23 <br/>
 * 
 * @author ：junkai.zhang
 */
public class MailData {

	/**
	 * 模板信息
	 */
	private TCMailTemplate mailTemplate;

	/**
	 * 邮件明细列表
	 */
	private List<TCMailSendDetail> details;

	public TCMailTemplate getMailTemplate() {
		return mailTemplate;
	}

	public void setMailTemplate(TCMailTemplate mailTemplate) {
		this.mailTemplate = mailTemplate;
	}

	public List<TCMailSendDetail> getDetails() {
		return details;
	}

	public void setDetails(List<TCMailSendDetail> details) {
		this.details = details;
	}

}
