package com.yo.mongo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShareService {

    @Autowired
    MongoTemplate mongoTemplate;


}