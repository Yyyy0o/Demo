package com.yo.garden.controller;


import com.yo.garden.dao.KdgtDao;
import com.yo.garden.entity.Kdgt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GardenController {

    @Autowired
    KdgtDao kdgtDao;

    @GetMapping("kdgt")
    public List<Kdgt> listKdgt(@RequestParam(defaultValue = "1") int page,
                               @RequestParam(defaultValue = "10") int size) {
        PageRequest request = PageRequest.of(page, size);
        return kdgtDao.findAll(request).getContent();
    }

    @Cacheable("kdgt")
    @GetMapping("kdgt/{id}")
    public Kdgt getKdgt(@PathVariable Long id) {
        return kdgtDao.findById(id).orElse(null);
    }



}
