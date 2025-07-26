package com.praveen.jobapplication.service.impl;

import com.praveen.jobapplication.Entity.Job;
import com.praveen.jobapplication.service.JobService;

import java.util.ArrayList;
import java.util.List;

public class JobServiceImpl implements JobService {

    private final List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        job.setId(nextId++);
        jobs.add(job);
    }

    @Override
    public Job findJobById(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                job.setTitle(updateJob.getTitle());
                job.setDescription(updateJob.getDescription());
                job.setMinSalary(updateJob.getMinSalary());
                job.setMaxSalary(updateJob.getMaxSalary());
                job.setLocation(updateJob.getLocation());
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean deleteJob(Long id) {
        for(Job job : jobs){
            if(job.getId().equals(id)){
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

}
