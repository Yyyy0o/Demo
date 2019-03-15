package com.yo.photo.repository;

import com.yo.photo.entity.TKKdgt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KdgtRepository extends JpaRepository<TKKdgt, Long> {
}
