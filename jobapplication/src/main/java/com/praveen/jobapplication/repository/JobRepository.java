package com.praveen.jobapplication.repository;

import com.praveen.jobapplication.Entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {

}
