package com.yo.mongo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Share {

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
