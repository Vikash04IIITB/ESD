package com.example.springweb.service;

import com.example.springweb.dto.CustomerRequest;
import com.example.springweb.dto.ProductsRequest;
import com.example.springweb.dto.ProductsResponse;
import com.example.springweb.entity.Customer;
import com.example.springweb.entity.Products;
import com.example.springweb.helper.EncryptionService;
import com.example.springweb.mapper.ProductMapper;
import com.example.springweb.repo.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo repo;
    private final ProductMapper mapper;
    private final EncryptionService encryptionService;

    public Products addProduct(ProductsRequest request) {
        System.out.println("==================== create service");
        Products product = mapper.toEntity(request);
        repo.save(product);
        return product;
    }


    public ProductsResponse getProductById(Long id) {
        System.out.println("==================== fetch service");
        Products product = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
        return mapper.toDto(product);
    }
}