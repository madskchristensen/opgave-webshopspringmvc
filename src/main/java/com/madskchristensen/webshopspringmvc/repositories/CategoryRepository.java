package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
