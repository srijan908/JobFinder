package com.resume.jobfinder.repositories;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.resume.jobfinder.models.JobPost;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SearchCriteriaRepositoryImpl implements SearchCriteriaRepository {

    @Autowired
    MongoClient mongoClient;

    @Autowired
    MongoConverter mongoConverter;

    @Override
    public List<JobPost> findByCriteria(String text) {

        MongoDatabase database = mongoClient.getDatabase("resume");
        MongoCollection<Document> collection = database.getCollection("jobFinder");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                        new Document("$search",
                            new Document("text",
                                new Document("query", text)
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                        new Document("$limit", 5L),
                        new Document("$sort",
                            new Document("field1", 1L))));

        List<JobPost> jobList = new ArrayList<>();
        result.forEach(document -> jobList.add(mongoConverter.read(JobPost.class, document)));
        return jobList;
    }
}
