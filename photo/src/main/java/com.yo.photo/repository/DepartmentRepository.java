package com.yo.photo.repository;

import com.yo.photo.entity.TKDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<TKDepartment, Long> {

    List<TKDepartment> findAllByKdgtTabId(Long kdgtId);
}
