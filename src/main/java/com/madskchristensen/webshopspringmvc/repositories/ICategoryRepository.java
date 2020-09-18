package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;

public interface ICategoryRepository {
        public Category read(long id);
    }
