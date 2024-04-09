package com.Freddie.job_application_system.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    private final CompanyServices companyServices;

    public CompanyController(CompanyServices companyServices) {
        this.companyServices = companyServices;
    }
    @PostMapping
    public ResponseEntity<String> addCompany(@RequestBody Company company) {
        companyServices.createCompany(company);
        return new ResponseEntity<>("Company created successfully!",HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies(){
        return new ResponseEntity<> (companyServices.getAllCompanies(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company){
        companyServices.updateCompany(company,id);
        return   new ResponseEntity<> ("Company Updated!", HttpStatus.OK);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCompany(@PathVariable Long id){
        boolean isDeleted = companyServices.deleteCompanyById(id);
        if(isDeleted){
            return new ResponseEntity<> ("Company Deleted!", HttpStatus.OK);
        }  else {
            return new ResponseEntity<> ("Company Not Found!", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompany(@PathVariable Long id){
        Company company = companyServices.getCompanyById(id);
        if(company != null){
            return new ResponseEntity<> (company, HttpStatus.OK);
        } else {
            return new ResponseEntity<> ( HttpStatus.NOT_FOUND);
        }
    }
}
