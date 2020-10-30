package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;
import com.madskchristensen.webshopspringmvc.util.RepositoryManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    private Connection conn;

    public ProductRepositoryImpl(Connection conn) throws SQLException {
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
            PreparedStatement getSingleProduct = conn.prepareStatement("SELECT * FROM product WHERE id = ?");
            getSingleProduct.setLong(1,id);
            ResultSet rs = getSingleProduct.executeQuery();

            rs.next();

            productToReturn = new Product();
            productToReturn.setId(rs.getLong(1));
            productToReturn.setName(rs.getString(2));
            productToReturn.setPrice(rs.getDouble(3));
            productToReturn.setDescription(rs.getString(4));

            Company company = new Company();
            long companyID = rs.getLong(5);
            company.setId(RepositoryManager.getInstance().getCompanyRepository().read(companyID).getId());
            company.setName(RepositoryManager.getInstance().getCompanyRepository().read(companyID).getName());
            company.setCompanyDescription(RepositoryManager.getInstance().getCompanyRepository().read(companyID).getCompanyDescription());

            Category category = new Category();
            long categoryID = rs.getLong(6);

            category.setId(RepositoryManager.getInstance().getCategoryRepository().read(categoryID).getId());
            category.setName(RepositoryManager.getInstance().getCategoryRepository().read(categoryID).getName());

            productToReturn.setCompanyInProductUsingCompany(company);
            productToReturn.setCategoryInProductUsingCategory(category);
        }

        catch(SQLException s) {
            s.printStackTrace();
        }

        return productToReturn;
    }

    @Override
    public List<Product> readAll() {
        List<Product> allProducts = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM product");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product tempProduct = new Product();
                tempProduct.setId(rs.getLong(1));
                tempProduct.setName(rs.getString(2));
                tempProduct.setPrice(rs.getDouble(3));
                tempProduct.setDescription(rs.getString(4));
                tempProduct.setCompanyInProductUsingCompany(RepositoryManager.getInstance().getCompanyRepository().read(rs.getLong(5)));
                tempProduct.setCategoryInProductUsingCategory(RepositoryManager.getInstance().getCategoryRepository().read(rs.getLong(6)));
                allProducts.add(tempProduct);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allProducts;
    }

    @Override
    public boolean update(Product product) {
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE product SET name=?, price=?, description=?, company_id=?, category_id=?, WHERE id=?");
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setLong(3, product.getId());
            ps.setString(4, product.getDescription());
            ps.setLong(5, product.getCompany().getId());
            ps.setLong(6, product.getCategory().getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("den er gal i update");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM product WHERE id=?");
            ps.setLong(1, id);
            ps.execute();
            System.out.println("Product at ID " + id + " has been deleted");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Something went wrong product ID: " + id);
            return false;
        }
    }
}