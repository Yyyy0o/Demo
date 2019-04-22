package com.yo.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yo.user.entity.Kdgt;
import com.yo.user.feign.KdgtFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 11:27
 */
@Controller
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    KdgtFeignClient userFeignClient;

    @RequestMapping("kdgt")
    public String kdgt() {
        return "kdgt";
    }

    @GetMapping("user/{id}")
    @ResponseBody
    @HystrixCommand
    public Kdgt listUser(@PathVariable String id) {
        Kdgt kdgt = userFeignClient.getKdgt(id);
        if (kdgt == null) {
            kdgt = new Kdgt();
            kdgt.setName("么有该园所");
        }
        return kdgt;
    }

}
