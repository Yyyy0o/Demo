package com.yo.user;

import com.google.gson.Gson;
import com.yo.user.entity.User;
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

    @Autowired
    Gson gson;

    @Test
    public void redisTest() throws InterruptedException {
        redisTemplate.opsForValue().set("no1", "2123131");
        Object no1 = redisTemplate.opsForValue().get("no1");
        System.out.println(no1);

        User user = new User(1, "张三", 12,"武侯区");
        redisTemplate.opsForValue().set("user2", user);
        Object user2 = redisTemplate.opsForValue().get("user2");
        System.out.println(user2);
        User object = gson.fromJson(user2.toString(), User.class);
        System.out.println(object.getName());
    }

}
