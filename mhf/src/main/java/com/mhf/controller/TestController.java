package com.mhf.controller;

import com.mhf.common.api.frequency.annotation.Frequency;
import com.mhf.common.api.jsonwebtoken.annotation.Authorization;
import com.mhf.common.api.mail.biz.IMailService;
import com.mhf.common.api.mail.domain.MailData;
import com.mhf.common.api.mail.domain.TCMailSendDetail;
import com.mhf.common.api.mail.domain.TCMailTemplate;
import com.mhf.common.api.redis.biz.IRedisService;
import com.mhf.common.base.controller.BaseController;
import com.mhf.common.base.entity.JsonContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestController extends BaseController{

    @Autowired
    private IRedisService service;
    @Autowired
    private IMailService mailService;

    @Frequency
    @Authorization
    @RequestMapping("/hello/{name}")
    public JsonContainer hello(@PathVariable String name){
        JsonContainer jsonContainer = getJsonContainer();
        String key = "key";
        service.set(key, name);
        service.defaultExpire(key);
        System.out.println(service.get(key));
        System.out.println(service.getExpire(key));
        setSuccessMessage(jsonContainer, name);
        return jsonContainer;
    }

    @RequestMapping("/hello1/{name}")
    public String hello1(@PathVariable String name){
        return name;
    }

    @RequestMapping("/mail/{text}")
    public JsonContainer mail(@PathVariable String text){
        JsonContainer jsonContainer = getJsonContainer();

        MailData mailData = new MailData();
        TCMailTemplate mailTemplate = new TCMailTemplate();
        mailTemplate.setSubject("mfh测试");
        mailData.setMailTemplate(mailTemplate);

        List<TCMailSendDetail> details = new ArrayList<>();
        TCMailSendDetail detail = new TCMailSendDetail();
        detail.setSentTo("295322187@qq.com");
        detail.setHtml(text);

        details.add(detail);
        mailData.setDetails(details);

        mailService.sendMail(mailData);


        setSuccessMessage(jsonContainer, text);
        return jsonContainer;
    }
}
