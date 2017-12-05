package com.mhf.common.api.mail.domain;

import com.mhf.common.business.domain.BaseEntity;

//@Entity(name = "TCMailTemplate")
//@Table(name = "T_C_MAIL_TEMPLATE")
public class TCMailTemplate extends BaseEntity {

	private String code;

	private String templateName;

	private String filePrefix;

	private String fileName;

	private String subject;

	public TCMailTemplate() {
		super();
	}

	public TCMailTemplate(String code) {
		super();
		this.code = code;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public String getFilePrefix() {
		return filePrefix;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
