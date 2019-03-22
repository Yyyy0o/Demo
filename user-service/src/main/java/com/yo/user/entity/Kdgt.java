package com.yo.user.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Kdgt {

    private long id;
    private String name;
    private String province;
    private String type;
    private String freeType;
    private String city;
    private String county;
    private String address;
    private String parentId;
    private String imageurl;
    private String synopsis;
    private String english;
    private String creatorId;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    private String state;
    private String updaterId;
    @JsonFormat(pattern = "yyyy年MM月dd日 HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;

}
