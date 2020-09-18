package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class productRepositoryImpl implements IProductRepository {
    private Connection conn;

    public productRepositoryImpl() throws SQLException {
        this.conn = DatabaseConnectionManager.getInstance().getDatabaseConnection();
    }

    @Override
    public boolean create(Product product) {
        try {
            PreparedStatement createSingleProduct = conn.prepareStatement("INSERT INTO product " +
                    "(name, price, description, company_id, category_id)" +
                    "VALUES(?, ?, ?, ?, ?)");

            createSingleProduct.setString(1, product.getName());
            createSingleProduct.setDouble(2, product.getPrice());
            createSingleProduct.setString(3, product.getDescription());
            createSingleProduct.setLong(4, product.getCompany().getId());
            createSingleProduct.setLong(5, product.getCategory().getId());
            createSingleProduct.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Product read(long id) {
        Product productToReturn = new Product();
        try {
            PreparedStatement getSingleProduct = conn.prepareStatement("SELECT * FROM products WHERE id = ?");
            getSingleProduct.setLong(1,id);
            ResultSet rs = getSingleProduct.executeQuery();
            while(rs.next()){
                productToReturn = new Product();
                productToReturn.setId(rs.getLong(1));
                productToReturn.setName(rs.getString(2));
                productToReturn.setPrice(rs.getDouble(3));

            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return productToReturn;
    }

    @Override
    public List<Product> readAll() {
        List<Product> allProducts = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product tempStudent = new Product();
                tempStudent.setId(rs.getLong(1));
                tempStudent.setName(rs.getString(2));
                tempStudent.setPrice(rs.getDouble(3));
                allProducts.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    @Override
    public boolean update(Product product) {
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET name=?, price=? WHERE id=?");
            ps.setString(1,product.getName());
            ps.setDouble(2,product.getPrice());
            ps.setLong(3,product.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("den er gal i update");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long idToDelete) {
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE id=?");
            ps.setLong(1,idToDelete);
            ps.execute();
            System.out.println("Student at ID " + idToDelete + " has been deleted");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong Student ID: " + idToDelete);
            return false;
        }
    }
}