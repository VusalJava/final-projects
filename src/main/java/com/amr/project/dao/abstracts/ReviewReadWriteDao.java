package com.amr.project.dao.abstracts;

import com.amr.project.model.entity.Review;

import java.util.List;

public interface ReviewReadWriteDao extends ReadWriteDao<Review, Long>{
    void saveReview(Review review);
    List<Review> getAllReviewsById(Long id);
    List<Review> getAllNotModeratedReviews();
}
