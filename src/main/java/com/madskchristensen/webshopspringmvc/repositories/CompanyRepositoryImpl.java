package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.models.Product;

import java.util.List;

public class CompanyRepositoryImpl implements IProductRepository {
    @Override
    public boolean create(Product student) {
        return false;
    }

    @Override
    public Product read(long id) {
        return null;
    }

    @Override
    public List<Product> readAll() {
        return null;
    }

    @Override
    public boolean update(Product student) {
        return false;
    }

    @Override
    public boolean delete(long id) {
        return false;
    }
}
