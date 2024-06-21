package com.Freddie.job_application_system.repo;

import com.Freddie.job_application_system.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
