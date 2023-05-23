package com.dikbiyik.ws.product.service;

import org.springframework.stereotype.Service;

import com.dikbiyik.ws.base.BaseAdditionalFields;
import com.dikbiyik.ws.base.service.BaseService;
import com.dikbiyik.ws.product.Product;
import com.dikbiyik.ws.product.repository.ProductRepository;

@Service
public class ProductService extends BaseService<Product, ProductRepository> {
    
    public ProductService(ProductRepository productRepository){
        super(productRepository);
    }


    public Product updateProduct(Long id, Product product){
        Product productInDB = this.findByIdWithControl(id);
        BaseAdditionalFields baseAdditionalFields = productInDB.getBaseAdditionalFields();

        if(baseAdditionalFields == null){
            baseAdditionalFields = updateBaseAdditionalFields();
        }

        productInDB.setId(id);
        productInDB.setBaseAdditionalFields(baseAdditionalFields);
        productInDB.setProductName(productInDB.getProductName());
        productInDB.setComments(productInDB.getComments());
        productInDB.setPrice(product.getPrice());
        this.save(productInDB);
        return productInDB;
    }
    
}
