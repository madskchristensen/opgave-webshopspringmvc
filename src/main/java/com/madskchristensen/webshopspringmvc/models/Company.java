package com.madskchristensen.webshopspringmvc.models;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private List<Product> list;
    private String companyDescription;

    public Company(List<Product> list, String companyDescription) {
        this.list = new ArrayList<>();
        this.companyDescription = companyDescription;
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