package com.dikbiyik.ws.entity.product.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.entity.product.Product;
import com.dikbiyik.ws.entity.product.dto.ProductSaveDtoRequest;
import com.dikbiyik.ws.entity.product.dto.ProductSaveDtoResponse;
import com.dikbiyik.ws.entity.product.mapper.ProductMapper;
import com.dikbiyik.ws.entity.product.repository.ProductRepository;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {
    
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper){
        super(productRepository);
        this.productMapper = productMapper;
    }

    public ProductSaveDtoResponse saveProduct(ProductSaveDtoRequest productSaveDtoRequest){
        return productMapper.productToProductSaveDtoResponse(this.save(productMapper.productSaveRequestDtoToProduct(productSaveDtoRequest)));
    }
    

    @Override
    public void delete(Product entity) {
        // TODO Auto-generated method stub
        super.delete(entity);
    }

    @Override
    public void deleteById(Long id) {
        // TODO Auto-generated method stub
        super.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        // TODO Auto-generated method stub
        return super.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        // TODO Auto-generated method stub
        return super.findById(id);
    }

    @Override
    public Product findByIdWithControl(Long id) {
        // TODO Auto-generated method stub
        return super.findByIdWithControl(id);
    }

    @Override
    public boolean isExist(Long id) {
        // TODO Auto-generated method stub
        return super.isExist(id);
    }

    @Override
    public Product save(Product entity) {
        // TODO Auto-generated method stub
        return super.save(entity);
    }
}
