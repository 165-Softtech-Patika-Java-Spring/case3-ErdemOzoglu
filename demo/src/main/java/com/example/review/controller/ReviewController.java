package com.example.review.controller;

import com.example.review.dto.ReviewDto;
import com.example.review.dto.ReviewReviewsResponseDto;
import com.example.review.service.ReviewEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewEntityService reviewEntityService;

    @PostMapping("/saveReview")
    public ResponseEntity saveReview(@RequestBody ReviewDto reviewDto) {

        reviewDto = reviewEntityService.save(reviewDto);

        return ResponseEntity.ok(reviewDto);
    }

    @DeleteMapping("/deleteReview/{id}")
    public ResponseEntity deleteReview(@PathVariable Long id) {

        reviewEntityService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @GetMapping("/getByUserReviews/{userId}")
    public ResponseEntity getByUserReviews(@PathVariable Long userId){

         ReviewReviewsResponseDto reviewUserReviewsResponseDto = reviewEntityService.getByUserReview(userId);

        return ResponseEntity.ok(reviewUserReviewsResponseDto);
    }

    @GetMapping("/getByProductReviews/{productId}")
    public ResponseEntity getByProductReviews(@PathVariable Long productId){

        ReviewReviewsResponseDto reviewUserReviewsResponseDto = reviewEntityService.getByProductReview(productId);

        return ResponseEntity.ok(reviewUserReviewsResponseDto);
    }


}
