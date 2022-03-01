package com.example.product.converter;

import com.example.product.dto.ProductDto;
import com.example.product.entity.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductConverter {

    ProductConverter INSTANCE = Mappers.getMapper(ProductConverter.class);

    ProductDto convertToProductDto(ProductEntity productEntity);

    ProductEntity convertToProductEntity(ProductDto productDto);


}
