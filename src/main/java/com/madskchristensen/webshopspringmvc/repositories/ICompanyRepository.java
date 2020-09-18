package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Company;

public interface ICompanyRepository {
    public Company read(long id);
}
