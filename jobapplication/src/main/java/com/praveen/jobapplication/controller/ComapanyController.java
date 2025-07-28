package com.praveen.jobapplication.controller;

import com.praveen.jobapplication.Entity.Company;
import com.praveen.jobapplication.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComapanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/company")
    public ResponseEntity<List<Company>> findAll(){
        return new ResponseEntity<>(companyService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = companyService.findCompanyById(id);
        if(company != null){
            return new ResponseEntity<>(company, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/company/{id}")
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        companyService.createCompany(company);
        return new ResponseEntity<>("Company created successfully...!", HttpStatus.CREATED);
    }

    @PutMapping("/company/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        boolean result = companyService.updateCompany(id, company);
        if(result){
            return new ResponseEntity<>("Company updated sucessfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/company/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean company = companyService.deleteCompany(id);
        if(company){
            return new ResponseEntity<>("Company deleted sucessfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
