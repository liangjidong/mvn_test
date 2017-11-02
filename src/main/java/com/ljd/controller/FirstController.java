package com.ljd.controller;

import com.ljd.pojo.config.ConfigBean;
import com.ljd.pojo.config.ConfigUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by author on 2017/10/31.
 */
@RestController
@EnableConfigurationProperties({ConfigBean.class, ConfigUser.class})
public class FirstController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private Integer age;

    @Autowired
    private ConfigBean configBean;

    @Autowired
    private ConfigUser configUser;

    @RequestMapping("/test")
    public String test() {
        return "test from ljd+++++" + " name:" + name + ", age:" + age;
    }

    @RequestMapping("/configBean")
    public String configBean() {
        return configBean.toString();
    }

    @RequestMapping("/configUser")
    public String configUser(){
        return configUser.toString();
    }
}
