package com.madskchristensen.webshopspringmvc.models;

import com.madskchristensen.webshopspringmvc.util.RepositoryManager;

import java.sql.SQLException;

public class Product {
    private long id;
    private String name;
    private double price;
    private String description;
    private Company company;
    private Category category;

    public Product(long id, String name, double price, String description, Company company, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.company = company;
        this.category = category;
    }

    public Product() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Long id) {
        try {
            this.company = RepositoryManager.getInstance().getCompanyRepository().read(id);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(long id) {
        try {
            this.category = RepositoryManager.getInstance().getCategoryRepository().read(id);
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }

    public void setCompanyInProductUsingCompany(Company company) {
        this.company = company;
    }

    public void setCategoryInProductUsingCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", company=" + company +
                ", category=" + category +
                '}';
    }
}