package com.example.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductDto {


    private String productName;
    private BigDecimal price;
}
