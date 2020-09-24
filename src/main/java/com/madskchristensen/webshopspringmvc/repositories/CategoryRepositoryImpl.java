package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository{
    private Connection conn;

    public CategoryRepositoryImpl(Connection conn) throws SQLException {
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

    public List<Category> readAll() {
        List<Category> allCategories = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT *  FROM category");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Category category = new Category();

                category.setId(rs.getLong(1));
                category.setName(rs.getString(2));

                allCategories.add(category);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return allCategories;
    }
}
