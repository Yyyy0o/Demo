package com.yo.es.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @author zhouyao
 * @desc
 * @date 2019/4/23
 **/
@Data
@Entity
@Table(name = "t_k_share")
public class TKShare {

    @Id
    @GeneratedValue
    private Long id;

    private Long kdgt_tab_id;

    private String type;

    private Long target_tab_id;

    private String openid;

    private String state;

    private Date look_time;

    private Date like_time;

    private Date share_time;
}
