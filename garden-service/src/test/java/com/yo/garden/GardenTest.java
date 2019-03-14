package com.yo.garden;

import com.yo.garden.dao.KdgtDao;
import com.yo.garden.entity.Kdgt;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GardenTest {

    @Autowired
    KdgtDao kdgtDao;

    @Test
    public void test(){
        List<Kdgt> list = kdgtDao.findByNameLike("%家%");

        System.out.println(list.size());
    }

}
