package com.madskchristensen.webshopspringmvc.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    //private List<Product> list = new ArrayList<>();

    @OneToMany (mappedBy = "company")
    private Set<Product> products;

    public Company() {

    }

    public Company(long id, String name) {
        this.id = id;
        this.name = name;
    }


    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

/*    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }*/

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + products +
                '}';
    }
}