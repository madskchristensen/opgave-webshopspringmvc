package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;

import java.util.List;

public interface ICategoryRepository {
    Category read(long id);
    List<Category> readAll();
}