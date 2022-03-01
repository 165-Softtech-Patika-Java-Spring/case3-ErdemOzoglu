package com.example.product.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductPriceUpdateDto {

    private Long id;
    private BigDecimal price;
}
