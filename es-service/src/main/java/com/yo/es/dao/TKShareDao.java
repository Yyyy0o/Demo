package com.yo.es.dao;

import com.yo.es.entity.TKShare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/23
 **/
@Repository
public interface TKShareDao extends JpaRepository<TKShare, Long> {

}
