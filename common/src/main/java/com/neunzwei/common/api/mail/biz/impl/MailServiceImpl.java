package com.neunzwei.common.api.mail.biz.impl;

import com.alibaba.fastjson.JSON;
import com.neunzwei.common.api.freemarker.biz.IFreeMarkerService;
import com.neunzwei.common.api.freemarker.util.FreeMarkerUtil;
import com.neunzwei.common.api.mail.biz.IMailService;
import com.neunzwei.common.api.mail.constant.MailConstant;
import com.neunzwei.common.api.mail.domain.MailData;
import com.neunzwei.common.api.mail.domain.TCMailSendDetail;
import com.neunzwei.common.api.mail.domain.TCMailTemplate;
import com.neunzwei.common.business.biz.impl.BusinessServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.internet.MimeMessage;
import java.util.Date;

@Component
//@Transactional(value = TransactionConstant.OL, propagation = Propagation.REQUIRED)
public class MailServiceImpl extends BusinessServiceImpl implements IMailService {

//	@Autowired
	private FreeMarkerUtil fk;
	@Autowired
	private JavaMailSender javaMailSender;
//	@Autowired
//	@Qualifier("taskExecutor4mail")
	private TaskExecutor taskExecutor;
//	@Autowired
	private IFreeMarkerService freeMarkerService;
//	@Autowired
//	private ITCMailTemplateService mailTemplateService;
//	@Autowired
//	private ITCMailSendDetailService mailSendDetailService;

//	@Value("#{propertiesReader['mail.sentFrom']}")
	private String sentFrom = "295322187@qq.com";
//	@Value("#{propertiesReader['mail.defaultEncoding']}")
	private String defaultEncoding = "UTF-8";

	public void sendMail(MailData mailData) {
		// 根据code查询模板
		//mailData.setMailTemplate(mailTemplateService.findByCode(mailData.getMailTemplate().getCode()));
		for (TCMailSendDetail detail : mailData.getDetails()) {
			// 如果sentFrom为空，则赋予默认值
			detail.setSentFrom(sentFrom);
			// 暂用同步
			// sendMailByAsyncMode(mailData.getMailTemplate(), detail);
			sendMailBySyncMode(mailData.getMailTemplate(), detail);
		}
	}

	/**
	 * 
	 * sendMailByAsyncMode:异步发送
	 * 
	 * @author junkai.zhang
	 * @param mailTemplate
	 * @param detail
	 */
	private void sendMailByAsyncMode(final TCMailTemplate mailTemplate, final TCMailSendDetail detail) {
		taskExecutor.execute(new Runnable() {
			public void run() {
				sendMailBySyncMode(mailTemplate, detail);
			}
		});
	}

	/**
	 * 
	 * sendMailBySyncMode:同步发送
	 * 
	 * @author junkai.zhang
	 * @param mailTemplate
	 * @param detail
	 */
	private void sendMailBySyncMode(TCMailTemplate mailTemplate, TCMailSendDetail detail) {

		MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, defaultEncoding);
			// 设置明细
			setDetail(mailTemplate, detail);
			// 显示名
			// from需要和username一致，不然会报501
			messageHelper.setFrom(detail.getSentFrom());
			// 收件邮箱
			messageHelper.setTo(detail.getSentTo());
			// 发送时间
			messageHelper.setSentDate(detail.getSentDate());
			// 邮件标题
			messageHelper.setSubject(mailTemplate.getSubject());
			// true 表示启动HTML格式的邮件
			messageHelper.setText(detail.getHtml(), true);
			// 发送
			this.javaMailSender.send(mimeMessage);
		} catch (Exception e) {
			// 发送不成功
			detail.setType(MailConstant.FAILURE);
			// 保存错误信息
			detail.setErrorMessage(getStackTrace(e));
			// 打印错误日志
			e.printStackTrace();
			//CommonConstant.ERRORDATA.error(detail, e);
		}
		//mailSendDetailService.saveMailSendDetail(detail);
	}

	private void setDetail(TCMailTemplate mailTemplate, TCMailSendDetail detail) {
		// 模板代码
		detail.setMailTemplateCode(mailTemplate.getCode());
		// 参数
		detail.setParams(JSON.toJSONString(detail.getParamsMap()));
		// 发送时间
		detail.setSentDate(new Date());
		// 邮件html
		// TODO 添加模板
//		detail.setHtml("test");
//		detail.setHtml(freeMarkerService.getFreeMarkerTemplate(mailTemplate.getFilePrefix(),
//				mailTemplate.getFileName(), detail.getParamsMap()));
		// 默认发送状态 1：成功 0：失败
		detail.setType(MailConstant.SUCCESS);
	}
}
