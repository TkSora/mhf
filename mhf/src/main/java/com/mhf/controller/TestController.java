package com.mhf.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/hello/{name}")
    public String hello(@PathVariable String name){
        StringUtils.isBlank(name);
        return name;
    }

}
