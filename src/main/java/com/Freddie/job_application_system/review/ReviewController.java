package com.Freddie.job_application_system.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
    private final ReviewServices reviewServices;

    public ReviewController(ReviewServices reviewServices) {
        this.reviewServices = reviewServices;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewServices.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        boolean isReviewSaved = reviewServices.addReview(companyId, review);
        if (isReviewSaved) return new ResponseEntity<>("Review added!", HttpStatus.OK);
        else {
            return new ResponseEntity<>("Review Not Saved!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewServices.getReview(companyId, reviewId), HttpStatus.OK);

    }
    @PutMapping("/reviews/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
                                               @RequestBody Review review){
        boolean isReviewUpdated = reviewServices.updateReview(companyId, reviewId, review);
        if(isReviewUpdated)
            return new ResponseEntity<>("Review updated!", HttpStatus.OK);
        else {
            return new ResponseEntity<>("Review Not updated!", HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/reviews/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
        boolean isReviewDeleted = reviewServices.deleteReview(companyId, reviewId);
        if(isReviewDeleted)
            return new ResponseEntity<>("Review Deleted!", HttpStatus.OK);
        else {
            return new ResponseEntity<>("Review Not Deleted!", HttpStatus.NOT_FOUND);
        }
        
    }
}
