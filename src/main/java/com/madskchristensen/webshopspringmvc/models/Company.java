package com.madskchristensen.webshopspringmvc.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private long id;
    private String companyDescription;
    private List<Product> list = new ArrayList<>();

    public Company() {

    }

    public Company(long id, String companyDescription) {
        this.id = id;
        this.companyDescription = companyDescription;
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
}