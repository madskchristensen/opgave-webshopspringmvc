package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Company;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
                company.setCompanyDescription(rs.getString(2));
            }

            return company;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
