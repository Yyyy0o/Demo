package com.yo.es;

import com.yo.es.dao.ShareDao;
import com.yo.es.dao.TKShareDao;
import com.yo.es.entity.Share;
import com.yo.es.entity.TKShare;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    TKShareDao tkShareDao;

    @Test
    public void fun2() {

        System.out.println(shareDao.count());

//        shareDao.deleteAll();

//        System.out.println(shareDao.count());
    }

    @Test
    public void fun1() {
        Page<TKShare> list = tkShareDao.findAll(PageRequest.of(0, 100000));

        for (int i = 0; i < list.getTotalPages(); i++) {
            list = tkShareDao.findAll(PageRequest.of(i, 100000));
            if (list == null) return;
            List<Share> collect = list.getContent().stream().map(bean -> {
                Share share = new Share();
                share.setId(bean.getId());
                share.setKdgtTabId(bean.getKdgt_tab_id());
                share.setType(bean.getType());
                share.setTarget(bean.getTarget_tab_id());
                share.setOpenid(bean.getOpenid());
                share.setLikeTime(bean.getLike_time());
                share.setLookTime(bean.getLook_time());
                share.setShareTime(bean.getShare_time());
                return share;
            }).collect(Collectors.toList());

            shareDao.saveAll(collect);
            System.out.println("total : " + list.getTotalPages() + " ; current : " + list.getNumber());
        }
    }

}
