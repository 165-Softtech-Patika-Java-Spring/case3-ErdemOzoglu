package com.example.review.service;

import com.example.product.dao.ProductDao;
import com.example.product.entity.ProductEntity;
import com.example.review.converter.ReviewConverter;
import com.example.review.dao.ReviewDao;
import com.example.review.dto.ReviewDto;
import com.example.review.dto.ReviewReviewsResponseDto;
import com.example.review.entity.ReviewEntity;
import com.example.user.dao.UserDao;
import com.example.user.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReviewEntityService {

    public final ReviewDao reviewDao;
    public final UserDao userDao;
    public final ProductDao productDao;

    public ReviewDto save(ReviewDto reviewDto) {

        ReviewEntity reviewEntity = ReviewConverter.INSTANCE.convertToReviewEntity(reviewDto);

        reviewEntity = reviewDao.save(reviewEntity);

        reviewDto = ReviewConverter.INSTANCE.convertToReviewDto(reviewEntity);

        return reviewDto;

    }

    public void delete(Long id) {
        reviewDao.deleteById(id);
    }

    public ReviewReviewsResponseDto getByUserReview(Long userId){

        List<ReviewEntity> reviewEntityList = reviewDao.findAllByUserId(userId);

        List<ReviewDto> reviewDtoList = new ArrayList<>();
        ReviewReviewsResponseDto reviewUserReviewsResponseDto = new ReviewReviewsResponseDto();

        if(reviewEntityList.isEmpty()){
            UserEntity userEntity = new UserEntity();
             Optional<UserEntity> optionalUserEntity = userDao.findById(userId);
            if(optionalUserEntity.isPresent()){
                userEntity = optionalUserEntity.get();
                reviewUserReviewsResponseDto.setErrorMessage(userEntity.getUsername()+" kullanıcı henüz bir yorum yazmamıştır.");
            }else{
                reviewUserReviewsResponseDto.setErrorMessage(userId+"id'ye sahip kullanıcı bulunamadı ve bu kullanıcı henüz bir yorum yazmamıştır.");

            }
        }else{

            for (ReviewEntity re : reviewEntityList) {
                ReviewDto rd = ReviewConverter.INSTANCE.convertToReviewDto(re);
                reviewDtoList.add(rd);
            }

            reviewUserReviewsResponseDto.setReviewDtoList(reviewDtoList);

        }

        return reviewUserReviewsResponseDto;

    }


    public ReviewReviewsResponseDto getByProductReview(Long productId){

        List<ReviewEntity> reviewEntityList = reviewDao.findAllByProductId(productId);

        List<ReviewDto> reviewDtoList = new ArrayList<>();
        ReviewReviewsResponseDto reviewUserReviewsResponseDto = new ReviewReviewsResponseDto();


        if(reviewEntityList.isEmpty()){
            ProductEntity productEntity = new ProductEntity();
            Optional<ProductEntity> productEntityOptional = productDao.findById(productId);
            if(productEntityOptional.isPresent()){
                productEntity = productEntityOptional.get();
                reviewUserReviewsResponseDto.setErrorMessage(productEntity.getProductName() +" ürüne henüz bir yorum yazılmamıştır.");
            }else{
                reviewUserReviewsResponseDto.setErrorMessage( productId +" id'ye sahip ürün bulunmamaktadır ve ürüne henüz bir yorum yazılmamıştır.");
            }
        }else{

            for (ReviewEntity re : reviewEntityList) {
                ReviewDto rd = ReviewConverter.INSTANCE.convertToReviewDto(re);
                reviewDtoList.add(rd);
            }

            reviewUserReviewsResponseDto.setReviewDtoList(reviewDtoList);

        }

        return reviewUserReviewsResponseDto;

    }


}
