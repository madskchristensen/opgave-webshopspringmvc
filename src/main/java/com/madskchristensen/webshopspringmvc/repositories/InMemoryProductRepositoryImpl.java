package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InMemoryProductRepositoryImpl implements IProductRepository {
    private List<Product> inMemoryDatabase;

    public InMemoryProductRepositoryImpl(){
        this.inMemoryDatabase = new ArrayList<Product>(
                Arrays.asList(
/*                        new Student(1, "Nicklas","Frederiksen", new Date(12312), 1234567890),
                        new Student(2, "Bent","Karlsen", new Date(2141241), 2407960591),
                        new Student(3, "Bob","Alicesen",new Date(12424141), 1234567890)*/
                )
        );
    }

    @Override
    public boolean create(Product student) {
        return false;
    }

    @Override
    public Product read(int id) {
        for(Product stu : inMemoryDatabase){
            if(stu.getId() == id){
                return stu;
            }
        }
        return null;
    }

    @Override
    public List<Product> readAll() {
        return inMemoryDatabase;
    }

    @Override
    public boolean update(Product student) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}