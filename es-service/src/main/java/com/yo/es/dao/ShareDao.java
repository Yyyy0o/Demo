package com.yo.es.dao;

import com.yo.es.entity.Share;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/23
 **/
@ResponseBody
public interface ShareDao extends ElasticsearchRepository<Share, Long> {

    List<Share> getByTypeAndKdgtTabId(String type, Long kdgtTabId);
}
