package com.yo.user.entity;

import lombok.Data;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 15:06
 */
@Data
public class User {

    public User(long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    private long id;
    private String name;
    private int age;
    private String address;

}
