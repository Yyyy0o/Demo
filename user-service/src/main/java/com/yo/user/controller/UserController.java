package com.yo.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import com.yo.user.entity.Kdgt;
import com.yo.user.feign.KdgtFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 11:27
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    KdgtFeignClient userFeignClient;

    @GetMapping("user/{id}")
    @HystrixCommand
    public Kdgt listUser(@PathVariable String id) {
        return userFeignClient.getKdgt(id);
    }

}
