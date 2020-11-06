package com.madskchristensen.webshopspringmvc.service;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.CategoryProduct;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.repositories.CategoryProductRepository;
import com.madskchristensen.webshopspringmvc.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;
    CategoryProductRepository categoryProductRepository;

    public ProductService(){
    }

    public void saveManyToManyCategoryProduct(Product product, Category... categories) {
        Set<CategoryProduct> categoryProductSet = new HashSet<>();

        for(Category category : categories) {
            categoryProductSet.add(new CategoryProduct(product.getId(), category.getId()));
        }

        categoryProductRepository.saveAll(categoryProductSet);
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
