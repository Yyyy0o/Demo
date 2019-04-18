package com.yo.user.controller;

import com.yo.user.entity.Kdgt;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 11:27
 */
@RestController
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("user/{id}")
    public Kdgt listUser(@PathVariable String id) {
//        List<ServiceInstance> instances = discoveryClient.getInstances("garden-service");
//        ServiceInstance instance = instances.get(0);
//        String url = "http://" + instance.getHost() + ":" + instance.getPort() + "/kdgt/" + id;
        String url = "http://garden-service/kdgt/" + id;
        Kdgt kdgt = restTemplate.getForObject(url, Kdgt.class);
        if (kdgt == null){
            kdgt = new Kdgt();
            kdgt.setName("么有该园所");
        }
        return kdgt;
    }

}
