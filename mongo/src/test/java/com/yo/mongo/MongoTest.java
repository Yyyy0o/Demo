package com.yo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import com.yo.mongo.entity.Share;
import org.bson.Document;
import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.security.cert.Certificate;
import java.util.Date;
import java.util.List;

public class MongoTest {

    @Test
    public void connect() {
        MongoClient client = new MongoClient("127.0.0.1", 27017);
        MongoDatabase demo = client.getDatabase("demo");
        System.out.println("connect success");
        System.out.println("MongoDatabase inof is : " + demo.getName());
        MongoIterable<String> collectionNames = demo.listCollectionNames();
        for (String name : collectionNames) {
            System.out.println(name);
        }

        FindIterable<Document> movie = demo.getCollection("movie").find();
        for (Document document : movie) {
            System.out.println(document.toJson());
        }
    }

    @Test
    public void fun1() {
        MongoTemplate template = new MongoTemplate(new MongoClient(), "share");

        Share share = new Share(2L, 2L, "1", 2L, "dfadfafadfad-xxxxxx", "1", new Date(), new Date(), new Date());

        template.insert(share,"share1");

        List<Share> shareList = template.find(Query.query(Criteria.where("type").is("1")), Share.class);

        System.out.println(shareList.size());
    }
}
