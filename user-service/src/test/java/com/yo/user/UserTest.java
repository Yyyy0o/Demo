package com.yo.user;

import com.alibaba.fastjson.JSON;
import com.yo.user.entity.Kdgt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: zhou yao
 * @Date: 2019/3/5 15:09
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    StringRedisTemplate template;

    @Test
    public void fun1() {
        template.convertAndSend("news", "message send");

        Kdgt kdgt = new Kdgt();
        kdgt.setName("测试员");
        template.opsForValue().set("kdgt", JSON.toJSONString(kdgt));

        Kdgt object = JSON.parseObject(template.opsForValue().get("kdgt"), Kdgt.class);

    }
}
