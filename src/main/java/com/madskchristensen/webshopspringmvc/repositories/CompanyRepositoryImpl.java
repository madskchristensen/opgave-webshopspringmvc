package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Category;
import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepositoryImpl implements ICompanyRepository {
    private Connection conn;

    public CompanyRepositoryImpl(Connection conn) throws SQLException {
        this.conn = DatabaseConnectionManager.getInstance().getDatabaseConnection();
    }

    @Override
    public Company read(long id) {
        try {
            Company company = new Company();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM company WHERE id=?");
            ps.setLong(1, id);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                company.setId(rs.getLong(1));
                company.setName(rs.getString(2));
                company.setCompanyDescription(rs.getString(3));
            }

            return company;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Company> readAll() {
        List<Company> allCompanies = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement("SELECT *  FROM company");
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                Company company = new Company();

                company.setId(rs.getLong(1));
                company.setName(rs.getString(2));
                company.setCompanyDescription(rs.getString(3));

                allCompanies.add(company);
            }

        } catch(SQLException e) {
            e.printStackTrace();
        }

        return allCompanies;
    }
}
