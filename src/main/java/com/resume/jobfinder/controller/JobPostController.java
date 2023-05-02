package com.resume.jobfinder.controller;

import com.resume.jobfinder.models.JobPost;
import com.resume.jobfinder.repositories.JobPostRepository;
import com.resume.jobfinder.repositories.SearchCriteriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class JobPostController {

    @Autowired
    JobPostRepository jobPostRepository;

    @Autowired
    SearchCriteriaRepository searchCriteriaRepository;

    @ApiIgnore
    @RequestMapping(value = "/")
    public void redirect(HttpServletResponse httpServletResponse) throws IOException {
        httpServletResponse.sendRedirect("/swagger-ui.html");
    }

    @GetMapping(value = "/getAllPosts")
    public List<JobPost> getJobPosts() {
        return jobPostRepository.findAll();
    }

    @GetMapping(value = "/getJobPost/{criteria}")
    public List<JobPost> getJobPostsByCriteria(@PathVariable String criteria) {
        return searchCriteriaRepository.findByCriteria(criteria);
    }

    @PostMapping(value = "jobPost")
    public JobPost addJobPost(@RequestBody JobPost newJobPost) {
        return jobPostRepository.save(newJobPost);
    }
}
