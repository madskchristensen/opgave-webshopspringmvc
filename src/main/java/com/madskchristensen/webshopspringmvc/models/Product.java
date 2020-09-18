package com.madskchristensen.webshopspringmvc.models;

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

    public void setCompany(Company company) {
        this.company = company;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}