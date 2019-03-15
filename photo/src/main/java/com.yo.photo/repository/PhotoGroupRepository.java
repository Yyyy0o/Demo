package com.yo.photo.repository;

import com.yo.photo.entity.TKPhotoGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoGroupRepository extends JpaRepository<TKPhotoGroup, Long> {

    List<TKPhotoGroup> findAllByType(String type);
}
