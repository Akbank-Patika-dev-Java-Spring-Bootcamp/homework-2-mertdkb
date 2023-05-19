package com.dikbiyik.ws.entity.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dikbiyik.ws.entity.product.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
