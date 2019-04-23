package com.yo.es;

import com.yo.es.dao.ShareDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/23
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ESTest {

    @Autowired
    ShareDao shareDao;

    @Test
    public void fun1() {

    }

}
