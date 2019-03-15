package com.yo.photo.repository;

import com.yo.photo.entity.TKPhotoTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotoTeacherRepository extends JpaRepository<TKPhotoTeacher,Long> {
}
