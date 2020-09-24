package com.madskchristensen.webshopspringmvc.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private long id;
    private String name;
    private String companyDescription;
    private List<Product> list = new ArrayList<>();

    public Company() {

    }

    public Company(long id, String name, String companyDescription) {
        this.id = id;
        this.name = name;
        this.companyDescription = companyDescription;
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

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }

    public String getCompanyDescription() {
        return companyDescription;
    }

    public void setCompanyDescription(String companyDescription) {
        this.companyDescription = companyDescription;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", companyDescription='" + companyDescription + '\'' +
                ", list=" + list +
                '}';
    }
}