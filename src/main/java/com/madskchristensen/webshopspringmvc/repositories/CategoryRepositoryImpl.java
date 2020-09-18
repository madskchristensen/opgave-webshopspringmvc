package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryRepositoryImpl implements ICategoryRepository{
    private Connection conn;

    public CategoryRepositoryImpl() throws SQLException {
        this.conn = DatabaseConnectionManager.getInstance().getDatabaseConnection();
    }

    @Override
    public Category read(long id) {
        Category category = new Category();
        try {
            PreparedStatement getSingleCategory = conn.prepareStatement("SELECT * FROM category WHERE id = ?");

            getSingleCategory.setLong(1,id);
            ResultSet rs = getSingleCategory.executeQuery();

            while(rs.next()){
                category = new Category();
                category.setId(rs.getLong(1));
                category.setName(rs.getString(2));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return category;
    }
}
