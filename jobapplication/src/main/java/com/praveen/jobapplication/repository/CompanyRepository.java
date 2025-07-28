package com.praveen.jobapplication.repository;

import com.praveen.jobapplication.Entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
