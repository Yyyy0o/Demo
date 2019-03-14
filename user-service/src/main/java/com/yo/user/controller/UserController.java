package com.yo.user.controller;

import com.yo.user.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 11:27
 */
@Controller
@RequestMapping("user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("/{id}")
    public String  getUser(@PathVariable Integer id,Model model) {

        model.addAttribute("user",new User(id,"张三",20,"中国广州"));
        return "/user/detail";
    }

    @RequestMapping("/list")
    public String  listUser(Model model) {
        List<User> userList = new ArrayList<User>();
        for (int i = 0; i <10; i++) {
            userList.add(new User(i,"张三"+i,20+i,"中国广州"));
        }

        model.addAttribute("users", userList);
        return "/user/list";
    }

}
