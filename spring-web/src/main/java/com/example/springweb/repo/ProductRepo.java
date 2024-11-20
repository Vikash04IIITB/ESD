package com.example.springweb.repo;

import com.example.springweb.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<Products, Long> {
    Optional<Products> findById(Long id);
}
