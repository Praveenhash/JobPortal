package com.praveen.jobapplication.service.impl;

import com.praveen.jobapplication.Entity.Job;
import com.praveen.jobapplication.repository.JobRepository;
import com.praveen.jobapplication.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class JobServiceImpl implements JobService {

    // private final List<Job> jobs = new ArrayList<>();
    @Autowired
    JobRepository jobRepository;

//    @Autowired
//    public JobServiceImpl(JobRepository jobRepository){
//        this.jobRepository = jobRepository;
//    }

    //private Long nextId = 1L;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
        //job.setId(nextId++);
        jobRepository.save(job);
    }

    @Override
    public Job findJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    @Override
    public boolean updateJob(Long id, Job updateJob) {
        Optional<Job> jobOptional = jobRepository.findById(id);
        if(jobOptional.isPresent()){
            Job job = jobOptional.get();
            job.setTitle(updateJob.getTitle());
            job.setDescription(updateJob.getDescription());
            job.setMinSalary(updateJob.getMinSalary());
            job.setMaxSalary(updateJob.getMaxSalary());
            job.setLocation(updateJob.getLocation());
            jobRepository.save(job);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteJob(Long id) {
        try{
            jobRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
