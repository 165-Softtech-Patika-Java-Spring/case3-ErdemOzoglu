package com.example.review.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReviewReviewsResponseDto {
    private List<ReviewDto> reviewDtoList;
    private String errorMessage;
}
