package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Product;

import java.util.List;

public interface IProductRepository {
    // CRUD operations
    public boolean create(Product student);

    public Product read(int id);

    public List<Product> readAll();

    public boolean update(Product student);

    public boolean delete(int id);
}