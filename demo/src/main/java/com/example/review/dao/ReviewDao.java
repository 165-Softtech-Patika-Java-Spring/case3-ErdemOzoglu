package com.example.review.dao;

import com.example.review.entity.ReviewEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewDao extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findAllByUserId(Long userId);
    List<ReviewEntity> findAllByProductId(Long productId);
}
