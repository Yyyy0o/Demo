package com.yo.es.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/23
 **/

@Data
@Document(indexName = "kdgt",type = "share")
public class Share {

    @Id
    private Long id;

    private Long kdgtTabId;

    private String type;

    private Long target;

    private String openid;

    private Date lookTime;

    private Date likeTime;

    private Date shareTime;

}
