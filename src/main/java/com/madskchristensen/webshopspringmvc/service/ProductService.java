package com.madskchristensen.webshopspringmvc.service;

import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductService(){
    }

    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if(product.isEmpty()){
            throw new RuntimeException("Product not found");
        }
        return product.get();
    }

    public List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }

    public void create(Product product){
        productRepository.save(product);
    }
    public void update(Product product){
        productRepository.save(product);
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
