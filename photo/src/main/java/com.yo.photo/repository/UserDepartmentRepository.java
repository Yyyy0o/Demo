package com.yo.photo.repository;

import com.yo.photo.entity.TKUserDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDepartmentRepository extends JpaRepository<TKUserDepartment, Long> {

    List<TKUserDepartment> findAllByDepartmentTabId(long departmentId);
}
