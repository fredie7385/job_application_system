package com.Freddie.job_application_system.company;

import java.util.List;

public interface CompanyServices {
    List<Company> getAllCompanies();
    boolean updateCompany(Company company,Long id);
    void createCompany(Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);
}
