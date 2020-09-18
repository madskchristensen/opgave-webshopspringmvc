package com.madskchristensen.webshopspringmvc.models;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class Product {
    private int id;
    private String firstName;
    private String lastName;
    @DateTimeFormat(pattern = "yyyy-MM-dd") // needed for input field on html pages (in order to serve the right format)
    private LocalDate enrollmentDate;
    private String cpr;

    public Product(int id, String firstName, String lastName, int enrollmentYear, int enrollmentMonth, int enrollmentDay, String cpr) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.enrollmentDate = LocalDate.of(enrollmentYear, enrollmentMonth, enrollmentDay);
        this.cpr = cpr;
    }

    public Product() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public void setEnrollmentDate(int enrollmentYear, int enrollmentMonth, int enrollmentDay) {
        this.enrollmentDate = LocalDate.of(enrollmentYear, enrollmentMonth, enrollmentDay);
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", enrollmentDate=" + enrollmentDate +
                ", cpr='" + cpr + '\'' +
                '}';
    }
}