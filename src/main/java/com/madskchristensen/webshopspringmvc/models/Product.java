package com.madskchristensen.webshopspringmvc.models;

import javax.persistence.*;
import java.util.Set;


// Setter på company og category er lidt rodet. Default setter for begge tager imod id i stedet for object da Spring smed følgende fejl ved oprettelse af product:
// "Failed to convert property value of type 'java.lang.String' to required type"
// Virker til at Spring ikke kan tage imod en String fra frontend og konvertere til et objekt.
// Den lidt dumme løsning er at vi bare læser id og bruger repository til at sætte company og category
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private String description;

    @ManyToOne
    private Company company;

    @ManyToMany (mappedBy = "products")
    private Set<Category> categories;

    @OneToOne (mappedBy = "product")
    private CompanyDescription companydescription;

    public Product(long id, String name, double price, String description, Company company,  Set<Category> categories) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.company = company;
        this.categories = categories;
    }

    public Product() {
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
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


    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", company=" + company +
                ", categories=" + categories +
                '}';
    }
}