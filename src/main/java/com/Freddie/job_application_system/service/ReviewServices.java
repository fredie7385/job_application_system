package com.Freddie.job_application_system.service;

import com.Freddie.job_application_system.entity.Review;

import java.util.List;

public interface ReviewServices {
    List<Review> getAllReviews(Long companyId);
    boolean addReview(Long companyId, Review review);
    Review getReview(Long companyId, Long reviewId);
    boolean updateReview(Long companyId, Long reviewId, Review review);

    boolean deleteReview(Long companyId, Long reviewId);
}
