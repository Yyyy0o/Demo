package com.yo.photo.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "t_k_photo_group")
public class TKPhotoGroup {

    @Id
    private long id;
    private long photoId;
    private String type;
    private long groupId;
}
