package com.praveen.jobapplication.service;

import com.praveen.jobapplication.Entity.Job;
import org.springframework.stereotype.Service;

import java.util.List;


public interface JobService {

    List<Job> findAll();
    void createJob(Job job);

    Job findJobById(Long id);

    boolean updateJob(Long id, Job job);


    boolean deleteJob(Long id);
}
