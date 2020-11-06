package com.madskchristensen.webshopspringmvc.service;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.repositories.CategoryRepository;
import com.madskchristensen.webshopspringmvc.repositories.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService(){

    }

    public List<Category> findAll(){
        List<Category> categoryList = new ArrayList<>();
        categoryRepository.findAll().forEach(categoryList::add);
        return categoryList;
    }

    public Category findById(Long id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);

        if(optionalCategory.isEmpty()) {
            throw new RuntimeException();
        }

        return optionalCategory.get();
    }
}
