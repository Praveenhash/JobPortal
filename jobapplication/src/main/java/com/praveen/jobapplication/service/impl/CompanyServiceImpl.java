package com.praveen.jobapplication.service.impl;

import com.praveen.jobapplication.Entity.Company;
import com.praveen.jobapplication.repository.CompanyRepository;
import com.praveen.jobapplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    CompanyRepository companyRepository;

    @Override
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    @Override
    public Company findCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    @Override
    public void createCompany(Company company) {
        companyRepository.save(company);
    }

    @Override
    public boolean updateCompany(Long id, Company updateCompany) {
        Optional<Company> company = companyRepository.findById(id);
        if(company.isPresent()){
            Company company1 = company.get();
            company1.setName(updateCompany.getName());
            company1.setJobs(updateCompany.getJobs());
            company1.setReviews(updateCompany.getReviews());
            company1.setCompanyType(updateCompany.getCompanyType());
            company1.setCompanySize(updateCompany.getCompanySize());
            company1.setYearTurnOver(updateCompany.getYearTurnOver());
            companyRepository.save(company1);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteCompany(Long id) {
        try{
            Optional<Company> company = companyRepository.findById(id);
            if(company.isPresent()){
                companyRepository.deleteById(id);
                return true;
            }else{
                return false;
            }
        } catch (Exception e){
            return false;
        }
    }
}
