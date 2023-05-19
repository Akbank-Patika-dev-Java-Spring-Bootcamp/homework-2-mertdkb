package com.dikbiyik.ws.entity.product.mapper;

import org.mapstruct.Mapper;

import com.dikbiyik.ws.entity.product.Product;
import com.dikbiyik.ws.entity.product.dto.ProductSaveDtoRequest;
import com.dikbiyik.ws.entity.product.dto.ProductSaveDtoResponse;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product productSaveRequestDtoToProduct(ProductSaveDtoRequest dtoRequest);

    ProductSaveDtoResponse productToProductSaveDtoResponse(Product product);
}
