package com.Freddie.job_application_system.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>{
    List<Review> findByCompanyId(Long companyId);
}
