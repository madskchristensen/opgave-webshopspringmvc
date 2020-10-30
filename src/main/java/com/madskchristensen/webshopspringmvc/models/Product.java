package com.madskchristensen.webshopspringmvc.models;

import com.madskchristensen.webshopspringmvc.util.RepositoryManager;

import java.sql.SQLException;


// Setter på company og category er lidt rodet. Default setter for begge tager imod id i stedet for object da Spring smed følgende fejl:
// "Failed to convert property value of type 'java.lang.String' to required type"
// Virker til at Spring ikke kan tage imod en String fra frontend og konvertere til et objekt.
// Den lidt dumme løsning er at vi bare læser id og bruger repository til at sætte company og category
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

    public void setCompanyUsingObject(Company company) {
        this.company = company;
    }

    public void setCategoryUsingObject(Category category) {
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