package com.example.lab8_673380278_9_sec1.repository;

import com.example.lab8_673380278_9_sec1.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}