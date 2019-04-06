package com.yo.user.feign.fallback;

import com.yo.user.entity.Kdgt;
import com.yo.user.feign.KdgtFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/5
 **/
@Component
public class KdgtFeignClientFallback implements KdgtFeignClient {

    @Override
    public Kdgt getKdgt(String id) {
        Kdgt kdgt = new Kdgt();
        kdgt.setId(Long.valueOf(id));
        kdgt.setName("查询出现错误");
        return kdgt;
    }

}
