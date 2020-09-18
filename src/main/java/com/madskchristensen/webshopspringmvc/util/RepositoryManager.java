package com.madskchristensen.webshopspringmvc.util;

import com.madskchristensen.webshopspringmvc.repositories.*;

import java.sql.SQLException;

public class RepositoryManager {
    private static RepositoryManager instance;
    private IProductRepository productRepository;
    private ICompanyRepository companyRepository;
    private ICategoryRepository categoryRepository;

    /*
        Singleton klasse der har til ansvar at returnere et repository.
     */
    private RepositoryManager() throws SQLException {
        productRepository = new ProductRepositoryImpl(DatabaseConnectionManager.getInstance().getDatabaseConnection());
        companyRepository = new CompanyRepositoryImpl(DatabaseConnectionManager.getInstance().getDatabaseConnection());
        categoryRepository = new CategoryRepositoryImpl(DatabaseConnectionManager.getInstance().getDatabaseConnection());
    }

    public static RepositoryManager getInstance() throws SQLException {
        if (instance == null) {
            instance = new RepositoryManager();
        }

        return instance;
    }

    public IProductRepository getProductRepository() {
        return productRepository;
    }

    public ICompanyRepository getCompanyRepository() {
        return companyRepository;
    }

    public ICategoryRepository getCategoryRepository() {
        return categoryRepository;
    }
}
