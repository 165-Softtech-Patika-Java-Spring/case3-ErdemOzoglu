package com.example.review.converter;

import com.example.review.dto.ReviewDto;
import com.example.review.entity.ReviewEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReviewConverter {

    ReviewConverter INSTANCE = Mappers.getMapper(ReviewConverter.class);

    ReviewEntity convertToReviewEntity(ReviewDto reviewDto);

    ReviewDto convertToReviewDto(ReviewEntity reviewEntity);
}
