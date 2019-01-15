package org.spring.springboot.controller;

import org.spring.springboot.dubbo.CityDubboConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping
public class UserController {

    @Autowired
    CityDubboConsumerService dubboConsumerService;

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public String saveUser(){
        return dubboConsumerService.saveUser().toString();
    }
}
