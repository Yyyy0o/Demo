package com.yo.photo.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "t_k_department")
@ToString
public class TKDepartment{
    @Id
    private long id;
    private String departMentName;
    private long kdgtTabId;
    private String parentId;
    private String remark;
    private Date createTime;
    private String creatorId;
    private String updaterId;
    private Date updateTime;
    private String state;

}
