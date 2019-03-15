package com.yo.photo.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "t_k_photo_teacher")
public class TKPhotoTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private long photoTabId;
    private long userTabId;
    private Date createTime;

}
