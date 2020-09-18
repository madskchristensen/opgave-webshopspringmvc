package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Product;

import java.util.List;

public interface IProductRepository {
    // CRUD operations
    public boolean create(Product product);

    public Product read(long id);

    public List<Product> readAll();

    public boolean update(Product product);

    public boolean delete(long id);
}