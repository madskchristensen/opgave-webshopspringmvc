package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Company;

import java.util.List;

public interface ICompanyRepository {
    Company read(long id);
    List<Company> readAll();
}
