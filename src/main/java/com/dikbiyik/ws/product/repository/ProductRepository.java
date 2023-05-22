package com.dikbiyik.ws.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dikbiyik.ws.product.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
