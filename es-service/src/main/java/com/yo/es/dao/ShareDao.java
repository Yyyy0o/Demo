package com.yo.es.dao;

import com.yo.es.entity.Share;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/23
 **/
public interface ShareDao extends CrudRepository<Share, Long> {

    List<Share> getByTypeAndKdgtTabId(String type, Long kdgtTabId);
}
