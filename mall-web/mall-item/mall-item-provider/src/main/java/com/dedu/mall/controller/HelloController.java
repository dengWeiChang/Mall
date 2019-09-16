package com.dedu.mall.controller;

import com.dedu.mall.service.impl.CatetorySerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    private CatetorySerImpl ser;

    @GetMapping("/")
    public String hello() {
        return "SUCCESS";
    }

    @GetMapping("/mp")
    public String helloMP() {
        return new Integer(ser.count()).toString();
    }
}
