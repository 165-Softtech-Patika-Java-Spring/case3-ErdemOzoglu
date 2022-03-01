package com.example.review.dto;

import lombok.Data;

@Data
public class ReviewDto {

    private Long productId;
    private Long userId;
    private String reviewText;
}
