package com.syssian.ecommerce.repository;

import com.syssian.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // Custom query to filter products by category later if we want!
    List<Product> findByCategory(String category);
}