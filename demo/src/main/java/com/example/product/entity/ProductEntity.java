package com.example.product.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Getter
@Setter
@Entity
@Table(name = "PRODUCT")
public class ProductEntity {

    @Id
    @SequenceGenerator(name = "ProductEntity", sequenceName = "PRODUCT_ID_SEQ")
    @GeneratedValue(generator = "ProductEntity")
    private Long id;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRICE")
    private BigDecimal price;


}
