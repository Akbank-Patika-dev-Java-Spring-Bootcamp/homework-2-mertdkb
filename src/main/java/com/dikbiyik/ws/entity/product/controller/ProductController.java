package com.dikbiyik.ws.entity.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.entity.product.dto.ProductSaveDtoRequest;
import com.dikbiyik.ws.entity.product.service.ProductService;
import com.dikbiyik.ws.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1.0/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public GenericApiResponse postProduct(@RequestBody ProductSaveDtoRequest productSaveDtoRequest){
        return new GenericApiResponse(200, "Success", "168435135", productService.saveProduct(productSaveDtoRequest));
    }
}
