package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.CategoryProduct;
import org.springframework.data.repository.CrudRepository;

public interface CategoryProductRepository extends CrudRepository<CategoryProduct, Long> {
}
