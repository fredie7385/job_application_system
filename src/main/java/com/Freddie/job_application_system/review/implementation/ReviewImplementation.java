package com.Freddie.job_application_system.review.implementation;

import com.Freddie.job_application_system.company.Company;
import com.Freddie.job_application_system.company.CompanyServices;
import com.Freddie.job_application_system.review.Review;
import com.Freddie.job_application_system.review.ReviewRepository;
import com.Freddie.job_application_system.review.ReviewServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImplementation implements ReviewServices {
    private final ReviewRepository  reviewRepository;
    private final CompanyServices companyServices;

    public ReviewImplementation(ReviewRepository reviewRepository,
                                CompanyServices companyServices) {
        this.reviewRepository = reviewRepository;
        this.companyServices = companyServices;
    }

    @Override
    public List<Review> getAllReviews(Long companyId) {
        List<Review> reviews =reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyId, Review review) {
        Company company = companyServices.getCompanyById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }  else{
            return false;
        }
    }
    @Override
    public Review getReview(Long companyId, Long reviewId) {
       List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean updateReview(Long companyId, Long reviewId, Review updatedReview) {
        if(companyServices.getCompanyById(companyId) != null){
            updatedReview.setCompany(companyServices.getCompanyById(companyId));
            updatedReview.setId(reviewId);
            reviewRepository.save(updatedReview);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteReview(Long companyId, Long reviewId) {
        if(companyServices.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)){
            Review review = reviewRepository.findById(reviewId).orElse(null);
            Company company = review.getCompany();
            company.getReviews().remove(review);
            review.setCompany(null);
            companyServices.updateCompany(company, companyId);
            reviewRepository.deleteById(reviewId);
            return true;
        }  else {
            return false;
        }
    }
}
