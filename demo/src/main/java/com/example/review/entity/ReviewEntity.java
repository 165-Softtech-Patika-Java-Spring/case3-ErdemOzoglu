package com.example.review.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "REVIEW")
public class ReviewEntity {

    @Id
    @SequenceGenerator(name = "ReviewEntity", sequenceName = "REVIEW_ID_SEQ")
    @GeneratedValue(generator = "ReviewEntity")
    private Long id;

    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_TYPE", length = 200)
    private String reviewText;
}
