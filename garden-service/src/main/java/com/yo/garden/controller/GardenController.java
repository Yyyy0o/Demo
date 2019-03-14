package com.yo.garden.controller;


import com.yo.garden.dao.KdgtDao;
import com.yo.garden.entity.Kdgt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GardenController {

    @Autowired
    KdgtDao kdgtDao;


    @GetMapping("kdgt")
    public List<Kdgt> kdgt(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "10") int size) {
        PageRequest request = PageRequest.of(page, size);
        Kdgt kdgt = new Kdgt();
        Example<Kdgt> example = Example.of(kdgt);

        return kdgtDao.findAll(example,request).getContent();
    }


}
