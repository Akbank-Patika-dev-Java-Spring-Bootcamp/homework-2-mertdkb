package com.dikbiyik.ws.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.product.dto.ProductSaveRequestDto;
import com.dikbiyik.ws.product.dto.ProductUpdateRequestDto;
import com.dikbiyik.ws.product.service.ProductService;
import com.dikbiyik.ws.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1.0/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @PostMapping
    public GenericApiResponse postProduct(@RequestBody ProductSaveRequestDto productSaveDtoRequest){
        return new GenericApiResponse(200, "Success", "168435135", productService.saveProduct(productSaveDtoRequest));
    }

    @GetMapping
    public GenericApiResponse getAllProducts(){
        return new GenericApiResponse(200, "Success", "168432156", productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public GenericApiResponse getProductById(@PathVariable Long id){
        return new GenericApiResponse(200, "Success", "6874135", productService.getProductById(id));
    }

    @PutMapping("/{id}")
    public GenericApiResponse updatePrice(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        return new GenericApiResponse(200, "Success", "16841321", productService.updateProduct(id, productUpdateRequestDto));
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteProduct(@PathVariable Long id){
        productService.deleteById(id);
        return new GenericApiResponse(200, "Success", "4698461");
    }
}
