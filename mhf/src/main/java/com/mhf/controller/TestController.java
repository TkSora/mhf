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
import com.mhf.domain.Person;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
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

    @ApiOperation(value="hello1", notes="根据name回显")
    @ApiImplicitParam(name = "name", value = "具体名称", required = true, dataType = "String")
    @RequestMapping(value = "/hello1/{name}", method = RequestMethod.GET)
    public String hello1(@PathVariable String name){
        return name;
    }


    @RequestMapping(value = "/mail", method = RequestMethod.POST)
    @ApiOperation(nickname = "swagger-mail", value="邮件测试", notes="根据text发送邮件")
    @ApiImplicitParam(name = "person", value = "用户详细实体person", required = true, dataType = "Person")
    public JsonContainer mail(@RequestBody Person person){
        JsonContainer jsonContainer = getJsonContainer();

        MailData mailData = new MailData();
        TCMailTemplate mailTemplate = new TCMailTemplate();
        mailTemplate.setSubject("mfh测试");
        mailData.setMailTemplate(mailTemplate);

        List<TCMailSendDetail> details = new ArrayList<>();
        TCMailSendDetail detail = new TCMailSendDetail();
        detail.setSentTo(person.getEmail());
        detail.setHtml(person.getText());

        details.add(detail);
        mailData.setDetails(details);

        mailService.sendMail(mailData);


        setSuccessMessage(jsonContainer, person);
        return jsonContainer;
    }
}
