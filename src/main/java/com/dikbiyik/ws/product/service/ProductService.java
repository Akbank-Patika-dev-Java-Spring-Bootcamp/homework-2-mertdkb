package com.dikbiyik.ws.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.product.Product;
import com.dikbiyik.ws.product.dto.ProductGetResponeDto;
import com.dikbiyik.ws.product.dto.ProductSaveRequestDto;
import com.dikbiyik.ws.product.dto.ProductSaveResponseDto;
import com.dikbiyik.ws.product.dto.ProductUpdateRequestDto;
import com.dikbiyik.ws.product.dto.ProductUpdateResponseDto;
import com.dikbiyik.ws.product.mapper.ProductMapper;
import com.dikbiyik.ws.product.repository.ProductRepository;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {
    
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        super(productRepository);
        this.productMapper = productMapper;
    }

    public ProductSaveResponseDto saveProduct(ProductSaveRequestDto productSaveDtoRequest){
        return productMapper.productToProductSaveDtoResponse(this.save(productMapper.productSaveRequestDtoToProduct(productSaveDtoRequest)));
    }

    public ProductGetResponeDto getProductById(Long id){
        return productMapper.productToProductGetResponseDto(this.findByIdWithControl(id));
    }

    public List<ProductGetResponeDto> getAllProducts(){
        return productMapper.productsToProductGetResponseDtos(this.findAll());
    }

    public ProductUpdateResponseDto updateProduct(Long id, ProductUpdateRequestDto requestDto){
        Product productInDb = this.findByIdWithControl(id);
        Product product = productMapper.productUpdateRequestDtoToProduct(requestDto);
        product.setId(id);
        product.setBaseAdditionalFields(this.updateBaseAdditionalFields());
        product.setProductName(productInDb.getProductName());
        product.setComments(productInDb.getComments());
        this.save(product);
        return productMapper.productToProductUpdateDtoResponse(product);
    }
    
}
