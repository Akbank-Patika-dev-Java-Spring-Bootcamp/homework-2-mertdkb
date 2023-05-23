package com.dikbiyik.ws.product.controller.contract.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.product.Product;
import com.dikbiyik.ws.product.controller.contract.ProductControllerContract;
import com.dikbiyik.ws.product.dto.ProductGetResponeDto;
import com.dikbiyik.ws.product.dto.ProductSaveRequestDto;
import com.dikbiyik.ws.product.dto.ProductSaveResponseDto;
import com.dikbiyik.ws.product.dto.ProductUpdateRequestDto;
import com.dikbiyik.ws.product.dto.ProductUpdateResponseDto;
import com.dikbiyik.ws.product.mapper.ProductMapper;
import com.dikbiyik.ws.product.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductControllerContractImpl implements ProductControllerContract {

    private final ProductService productService;

    private final ProductMapper productMapper;

    @Override
    public ProductSaveResponseDto postProduct(ProductSaveRequestDto requestDto) {
        Product product = productService.save(productMapper.productSaveRequestDtoToProduct(requestDto));
        return productMapper.productToProductSaveDtoResponse(product);
    }

    @Override
    public List<ProductGetResponeDto> gelAllProducts() {
        return productMapper.productsToProductGetResponseDtos(productService.findAll());
    }

    @Override
    public ProductGetResponeDto getProductById(Long id) {   
        return productMapper.productToProductGetResponseDto(productService.findByIdWithControl(id));
    }

    @Override
    public ProductUpdateResponseDto updatePrice(Long id, ProductUpdateRequestDto requestDto) {
        Product response = productService.updateProduct(id, productMapper.productUpdateRequestDtoToProduct(requestDto));
        return productMapper.productToProductUpdateDtoResponse(response);
    }

    @Override
    public void deleteProduct(Long id) {
        productService.deleteById(id);
    }
    
}
