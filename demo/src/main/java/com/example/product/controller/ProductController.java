package com.example.product.controller;

import com.example.product.dto.ProductDto;
import com.example.product.dto.ProductPriceUpdateDto;
import com.example.product.service.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductEntityService productEntityService;

    @PostMapping("/saveProduct")
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto) {

        ProductDto productDto1 = productEntityService.save(productDto);

        return ResponseEntity.ok(productDto);
    }

    @GetMapping("/findAllProduct")
    public ResponseEntity findAllProduct() {

        List<ProductDto> productDtoList = productEntityService.findAll();

        return ResponseEntity.ok(productDtoList);
    }

    @GetMapping("/findByIdProduct/{id}")
    public ResponseEntity findByIdProduct(@PathVariable Long id){

        ProductDto productDto = productEntityService.findById(id);

        return ResponseEntity.ok(productDto);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {

        productEntityService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @PatchMapping("/updateProductPrice")
    public ResponseEntity updateProductPrice(@RequestBody ProductPriceUpdateDto productPriceUpdateDto) {

        ProductDto productDto = productEntityService.updatePrice(productPriceUpdateDto);

        return ResponseEntity.ok(productDto);
    }

}
