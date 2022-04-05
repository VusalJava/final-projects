package com.amr.project.webapp.controller;

import com.amr.project.converter.ReviewMapper;
import com.amr.project.model.dto.ReviewDto;
import com.amr.project.model.entity.Review;
import com.amr.project.service.abstracts.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/review")
public class ReviewRestController {

    private final ReviewMapper reviewMapper;
    private final ReviewService reviewService;

    //сохраняет в БД как новые review сущности, так и прошедшие/не прошедшие модерацию
    @PostMapping("/save")
    public void createShop(@RequestBody ReviewDto reviewDto) {
       reviewService.saveNewReview(reviewMapper.toEntity(reviewDto));
    }
    //возвращает отзывы по выбранному item, кроме не прошедших модерацию
    @PostMapping("/show")
    public ResponseEntity<List<ReviewDto>> getAllReviews(@RequestBody Long id) {

        List<Review> reviewList = reviewService.getAllReviewsById(id);

        return ResponseEntity.ok(reviewMapper.toDtoList(reviewList));
    }

    //возвращает все немодерированные отзывы по всем items
    @PostMapping("/show_not_moderated")
    public ResponseEntity<List<ReviewDto>> getAllNotModeratedReviews() {

        List<Review> reviewList = reviewService.getAllNotModeratedReviews();

        return ResponseEntity.ok(reviewMapper.toDtoList(reviewList));
    }
}
