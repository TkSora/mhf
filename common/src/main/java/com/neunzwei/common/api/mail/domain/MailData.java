package com.neunzwei.common.api.mail.domain;

import java.util.List;

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
