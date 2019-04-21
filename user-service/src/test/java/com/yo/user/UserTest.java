package com.yo.user;

import com.alibaba.fastjson.JSON;
import com.yo.user.entity.Kdgt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 15:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void fun1() {
        redisTemplate.convertAndSend("news", "message send");

        Kdgt kdgt = new Kdgt();
        kdgt.setName("测试员");
        redisTemplate.opsForValue().set("kdgt", kdgt);

        Kdgt object =   0520
        redisTemplate.opsForValue().get("kdgt");
        System.out.println(object);
    }
}
