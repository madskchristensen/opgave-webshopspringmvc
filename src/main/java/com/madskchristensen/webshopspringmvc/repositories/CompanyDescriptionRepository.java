package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.CompanyDescription;
import org.springframework.data.repository.CrudRepository;

public interface CompanyDescriptionRepository extends CrudRepository<CompanyDescription, Long> {
}
