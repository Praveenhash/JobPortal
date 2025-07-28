package com.praveen.jobapplication.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    //private String location;
    private String companyType;
    private int companySize;
    private String yearTurnOver;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviews;
    public Company(){}

    public Company(Long id, String name, String companyType, int companySize, String yearTurnOver, List<Job> jobs) {
        this.id = id;
        this.name = name;
        // this.location = location;
        this.companyType = companyType;
        this.companySize = companySize;
        this.yearTurnOver = yearTurnOver;
        this.jobs = jobs;
        //this.reviews = reviews;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public int getCompanySize() {
        return companySize;
    }

    public void setCompanySize(int companySize) {
        this.companySize = companySize;
    }

    public String getYearTurnOver() {
        return yearTurnOver;
    }

    public void setYearTurnOver(String yearTurnOver) {
        this.yearTurnOver = yearTurnOver;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
