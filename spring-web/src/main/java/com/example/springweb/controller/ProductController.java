package com.example.springweb.controller;

import com.example.springweb.dto.ProductsResponse;
import com.example.springweb.dto.ProductsRequest;
import com.example.springweb.entity.Products;
import com.example.springweb.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping // for post request
    public ResponseEntity<Products> addProduct(@RequestBody @Valid ProductsRequest request) {
        return ResponseEntity.ok(productService.addProduct(request));
    }
    @GetMapping("/{id}") // for get request to fetch a product by its ID
    public ResponseEntity<ProductsResponse> getProductById(@PathVariable("id") Long id) {
        ResponseEntity<ProductsResponse> ok = ResponseEntity.ok(productService.getProductById(id));
        return ok;
    }

}
