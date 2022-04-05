package com.amr.project.service.abstracts;

import com.amr.project.model.entity.Review;

import java.util.List;

public interface ReviewService extends ReadWriteService<Review, Long> {
    void saveNewReview(Review review);
    List<Review> getAllReviewsById( Long id);
    List<Review> getAllNotModeratedReviews();
}
