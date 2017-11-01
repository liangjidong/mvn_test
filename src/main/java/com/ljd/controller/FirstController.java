package com.ljd.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by author on 2017/10/31.
 */
@RestController
public class FirstController {

    @Value("${my.name}")
    private String name;
    @Value("${my.age}")
    private Integer age;

    @RequestMapping("/test")
    public String test() {
        return "test from ljd+++++" + " name:" + name + ", age:" + age;
    }
}
