package com.yo.mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import org.bson.Document;
import org.junit.Test;

public class MongoTest {

    @Test
    public void connect() {
        MongoClient client = new MongoClient("127.0.0.1", 27017);
        MongoDatabase demo = client.getDatabase("demo");
        System.out.println("connect success");
        System.out.println("MongoDatabase inof is : " + demo.getName());
        MongoIterable<String> collectionNames = demo.listCollectionNames();
        for (String name: collectionNames) {
            System.out.println(name);
        }

        FindIterable<Document> movie = demo.getCollection("movie").find();
        for (Document document: movie) {
            System.out.println(document.toJson());
        }
    }
}
