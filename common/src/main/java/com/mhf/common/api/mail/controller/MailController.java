package com.mhf.common.api.mail.controller;

import com.mhf.common.api.frequency.annotation.Frequency;
import com.mhf.common.api.jsonwebtoken.annotation.Authorization;
import com.mhf.common.api.mail.biz.IMailService;
import com.mhf.common.api.mail.domain.MailData;
import com.mhf.common.base.controller.BaseController;
import com.mhf.common.base.entity.JsonContainer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/*****************************************************************************/
/* 　　　　　　(C) Super Brand Mail Inc. 2014     　　　                     */
/*****************************************************************************/

// ***************************************************************************/
// * modified by 更新者 更新日 修改内容
// ***************************************************************************/
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