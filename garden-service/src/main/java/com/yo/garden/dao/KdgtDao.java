package com.yo.garden.dao;

import com.yo.garden.entity.Kdgt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KdgtDao extends JpaRepository<Kdgt, Long> {

    List<Kdgt> findByNameLike(String name);
}
