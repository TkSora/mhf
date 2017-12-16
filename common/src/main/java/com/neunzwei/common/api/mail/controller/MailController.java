package com.neunzwei.common.api.mail.controller;

import com.neunzwei.common.api.frequency.annotation.Frequency;
import com.neunzwei.common.api.jsonwebtoken.annotation.Authorization;
import com.neunzwei.common.api.mail.biz.IMailService;
import com.neunzwei.common.api.mail.domain.MailData;
import com.neunzwei.common.base.controller.BaseController;
import com.neunzwei.common.base.entity.JsonContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Frequency
@Authorization
@Controller
@RequestMapping("/ol/api/mail")
public class MailController extends BaseController {

	//@Autowired
	private IMailService service;

	@RequestMapping(value = "/send")
	@ResponseBody
	public JsonContainer send(@RequestBody MailData mailData) {
		JsonContainer jsonContainer = getJsonContainer();
		service.sendMail(mailData);
		setSuccessMessage(jsonContainer, null);
		return jsonContainer;
	}

}