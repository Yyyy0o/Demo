package com.yo.user.feign;

import com.yo.user.entity.Kdgt;
import com.yo.user.feign.fallback.KdgtFeignClientFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhouyao
 * @ddesc
 * @date 2019/4/5
 **/
@FeignClient(value = "garden-service",fallback = KdgtFeignClientFallback.class)
public interface KdgtFeignClient {

    @GetMapping("kdgt/{id}")
    Kdgt getKdgt(@PathVariable("id") String id);
}
