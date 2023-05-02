package com.resume.jobfinder.repositories;

import com.resume.jobfinder.models.JobPost;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface JobPostRepository extends MongoRepository<JobPost, String> {

}
