package com.dikbiyik.ws.product.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dikbiyik.ws.product.controller.contract.ProductControllerContract;
import com.dikbiyik.ws.product.dto.ProductGetResponeDto;
import com.dikbiyik.ws.product.dto.ProductSaveRequestDto;
import com.dikbiyik.ws.product.dto.ProductSaveResponseDto;
import com.dikbiyik.ws.product.dto.ProductUpdateRequestDto;
import com.dikbiyik.ws.product.dto.ProductUpdateResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1.0/products")
@RequiredArgsConstructor
public class ProductController  {
    
    private final ProductControllerContract productControllerContract;

    @PostMapping
    public ResponseEntity<ProductSaveResponseDto> postProduct(@RequestBody ProductSaveRequestDto productSaveDtoRequest){
        ProductSaveResponseDto response = productControllerContract.postProduct(productSaveDtoRequest);
        return ResponseEntity.ok().body(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductGetResponeDto>> getAllProducts(){
        List<ProductGetResponeDto> response = productControllerContract.gelAllProducts();
        return ResponseEntity.ok().body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductGetResponeDto> getProductById(@PathVariable Long id){
        ProductGetResponeDto response = productControllerContract.getProductById(id);
        return ResponseEntity.ok().body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductUpdateResponseDto> updatePrice(@PathVariable Long id, @RequestBody ProductUpdateRequestDto productUpdateRequestDto){
        ProductUpdateResponseDto response = productControllerContract.updatePrice(id, productUpdateRequestDto);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id){
        productControllerContract.deleteProduct(id);
        return ResponseEntity.ok().body("Deleted");
    }
}
