package com.madskchristensen.webshopspringmvc.repositories;

import com.madskchristensen.webshopspringmvc.models.Product;
import com.madskchristensen.webshopspringmvc.util.DatabaseConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImpl implements IStudentRepository {
    private Connection conn;

    public StudentRepositoryImpl(){
        this.conn = DatabaseConnectionManager.getDatabaseConnection();
    }

    @Override
    public boolean create(Product student) {
        try {
            PreparedStatement createSingleStudent = conn.prepareStatement("INSERT INTO students " +
                    "(firstname, lastname, enrollmentDate, cpr)" +
                    "VALUES(?, ?, ?, ?)");

            createSingleStudent.setString(1, student.getFirstName());
            createSingleStudent.setString(2, student.getLastName());
            createSingleStudent.setDate(3, java.sql.Date.valueOf(student.getEnrollmentDate()));
            createSingleStudent.setString(4, student.getCpr());
            createSingleStudent.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return true;
    }

    @Override
    public Product read(int id) {
        Product studentToReturn = new Product();
        try {
            PreparedStatement getSingleStudent = conn.prepareStatement("SELECT * FROM students WHERE id = ?");
            getSingleStudent.setInt(1,id);
            ResultSet rs = getSingleStudent.executeQuery();
            while(rs.next()){
                studentToReturn = new Product();
                studentToReturn.setId(rs.getInt(1));
                studentToReturn.setFirstName(rs.getString(2));
                studentToReturn.setLastName(rs.getString(3));
                studentToReturn.setEnrollmentDate(rs.getDate(4).toLocalDate());
                studentToReturn.setCpr(rs.getString(5));
            }
        }
        catch(SQLException s){
            s.printStackTrace();
        }
        return studentToReturn;
    }

    @Override
    public List<Product> readAll() {
        List<Product> allStudents = new ArrayList<Product>();
        try {
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM students");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Product tempStudent = new Product();
                tempStudent.setId(rs.getInt(1));
                tempStudent.setFirstName(rs.getString(2));
                tempStudent.setLastName(rs.getString(3));
                tempStudent.setEnrollmentDate(rs.getDate(4).toLocalDate());
                tempStudent.setCpr(rs.getString(5));
                allStudents.add(tempStudent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allStudents;
    }

    @Override
    public boolean update(Product student) {
        try{
            PreparedStatement ps = conn.prepareStatement("UPDATE students SET firstname=?, lastname=?,enrollmentDate=?,cpr=? WHERE id=?");
            ps.setString(1,student.getFirstName());
            ps.setString(2,student.getLastName());
            ps.setString(3,student.getEnrollmentDate().toString());
            ps.setString(4,student.getCpr());
            ps.setInt(5,student.getId());
            ps.execute();

            return true;
        } catch (SQLException e) {
            System.out.println("den er gal i update");
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean delete(int idToDelete) {
        try{
            PreparedStatement ps = conn.prepareStatement("DELETE FROM students WHERE id=?");
            ps.setInt(1,idToDelete);
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