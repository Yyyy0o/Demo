package com.yo.photo.entity;

import com.yo.photo.repository.DepartmentRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "t_k_kdgt")
public class TKKdgt {

    @Id
    private Long id;

    private String name;

    private String province;

    private String type;

    private String freeType;

    private String city;

    private String county;

    private String address;

    private Long parentId;

    private Long creatorId;

    private Date createTime;

    private String state;

    private Long updaterId;

    private Date updateTime;
}