package com.example.product.service;

import com.example.product.converter.ProductConverter;
import com.example.product.dao.ProductDao;
import com.example.product.dto.ProductDto;
import com.example.product.dto.ProductPriceUpdateDto;
import com.example.product.entity.ProductEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductEntityService {

    private final ProductDao productDao;

    public ProductDto save(ProductDto productDto) {
        ProductEntity productEntity = ProductConverter.INSTANCE.convertToProductEntity(productDto);
        productEntity = productDao.save(productEntity);
        productDto = ProductConverter.INSTANCE.convertToProductDto(productEntity);
        return productDto;
    }

    public List<ProductDto> findAll() {
        List<ProductDto> productDtoList = new ArrayList<>();
        List<ProductEntity> productEntityList = productDao.findAll();
        for (ProductEntity pel : productEntityList) {
            ProductDto pt = ProductConverter.INSTANCE.convertToProductDto(pel);
            productDtoList.add(pt);
        }
        return productDtoList;
    }

    public ProductDto findById(Long Id){

        Optional<ProductEntity> productEntityOptional = productDao.findById(Id);

        ProductEntity productEntity;
        if (productEntityOptional.isPresent()){
            productEntity = productEntityOptional.get();
        } else {
            throw new NotFoundException("Item not found!");
        }

        ProductDto productDto = ProductConverter.INSTANCE.convertToProductDto(productEntity);

        return productDto;
    }

    public void delete(Long id) {
        productDao.deleteById(id);
    }

    public ProductDto updatePrice(ProductPriceUpdateDto productPriceUpdateDto) {

        ProductEntity productEntity = productDao.getById(productPriceUpdateDto.getId());

        productEntity.setPrice(productPriceUpdateDto.getPrice());

        productEntity = productDao.save(productEntity);

        ProductDto productDto = ProductConverter.INSTANCE.convertToProductDto(productEntity);

        return productDto;
    }


}
