package com.yo.photo.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Data
@Entity
@Table(name = "t_k_user_department")
public class TKUserDepartment implements Serializable {

    @Id
    private long id;
    private long userTabId;
    private long departmentTabId;

}
