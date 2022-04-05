package com.amr.project.dao.impl;

import com.amr.project.dao.abstracts.ReviewReadWriteDao;
import com.amr.project.model.entity.Review;

import java.util.List;

public class ReviewReadWriteDaoImpl extends ReadWriteDaoImpl<Review, Long> implements ReviewReadWriteDao {

    @Override
    public void saveReview(Review review) {
        em.persist(review);
    }

    @Override
    public List<Review> getAllReviewsById(Long id) {
        //выбрать из БД все отзывы про вещь по её id, которые прошли модерацию
        return em.createQuery("select r from Review r where r.item = ?1 AND r.isModerateAccept = true ", Review.class)
                .setParameter(1, id).getResultList();
    }

    @Override
    public List<Review> getAllNotModeratedReviews() {
        //выбрать из БД все  отзывы про вещь по её id, которые ещё не модерировались
        return em.createQuery("select r from Review r where r.isModerated = false ", Review.class)
                .getResultList();
    }
}
