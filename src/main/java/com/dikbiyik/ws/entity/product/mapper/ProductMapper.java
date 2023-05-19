package com.dikbiyik.ws.entity.product.mapper;

import java.util.List;
import java.util.Optional;

import org.mapstruct.Mapper;

import com.dikbiyik.ws.entity.product.Product;
import com.dikbiyik.ws.entity.product.dto.ProductGetResponeDto;
import com.dikbiyik.ws.entity.product.dto.ProductSaveRequestDto;
import com.dikbiyik.ws.entity.product.dto.ProductSaveResponseDto;
import com.dikbiyik.ws.entity.product.dto.ProductUpdateRequestDto;
import com.dikbiyik.ws.entity.product.dto.ProductUpdateResponseDto;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productSaveRequestDtoToProduct(ProductSaveRequestDto dtoRequest);

    ProductSaveResponseDto productToProductSaveDtoResponse(Product product);

    ProductGetResponeDto productToProductGetResponseDto(Product product);

    List<ProductGetResponeDto> productsToProductGetResponseDtos(List<Product> findAll);

    Product productUpdateRequestDtoToProduct(ProductUpdateRequestDto requestDto);

    ProductUpdateResponseDto productToProductUpdateDtoResponse(Product product);
}
