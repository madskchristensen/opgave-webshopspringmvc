package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

}
