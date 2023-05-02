package com.resume.jobfinder.repositories;

import com.resume.jobfinder.models.JobPost;

import java.util.List;

public interface SearchCriteriaRepository {

    public List<JobPost> findByCriteria(String text);

}
