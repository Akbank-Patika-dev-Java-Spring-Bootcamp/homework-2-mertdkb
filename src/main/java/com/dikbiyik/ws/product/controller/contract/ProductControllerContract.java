package com.dikbiyik.ws.product.controller.contract;

import java.util.List;

import com.dikbiyik.ws.product.dto.ProductSaveRequestDto;
import com.dikbiyik.ws.product.dto.ProductSaveResponseDto;
import com.dikbiyik.ws.product.dto.ProductUpdateRequestDto;
import com.dikbiyik.ws.product.dto.ProductUpdateResponseDto;
import com.dikbiyik.ws.product.dto.ProductGetResponeDto;

public interface ProductControllerContract {
    
    ProductSaveResponseDto postProduct(ProductSaveRequestDto requestDto);

    List<ProductGetResponeDto> gelAllProducts();

    ProductGetResponeDto getProductById(Long id);

    ProductUpdateResponseDto updatePrice(Long id, ProductUpdateRequestDto requestDto);

    void deleteProduct(Long id);

    
}
