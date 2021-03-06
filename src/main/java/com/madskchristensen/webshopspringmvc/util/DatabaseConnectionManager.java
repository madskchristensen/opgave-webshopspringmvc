package com.madskchristensen.webshopspringmvc.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static DatabaseConnectionManager instance;
    private static String user;
    private static String password;
    private static String url;

    private DatabaseConnectionManager() {

    }

    public static DatabaseConnectionManager getInstance() {
        if (instance == null) {
            instance = new DatabaseConnectionManager();
        }

        return instance;
    }

    public Connection getDatabaseConnection() throws SQLException {
        Properties prop = new Properties();
        try {
            FileInputStream propertyFile = new FileInputStream("src/main/resources/application.properties");
            prop.load(propertyFile);
            this.user = prop.getProperty("spring.datasource.username");
            this.password = prop.getProperty("spring.datasource.password");
            this.url = prop.getProperty("spring.datasource.url");
        }
        catch(FileNotFoundException e){
            System.out.println("File could not be found");
            e.printStackTrace();
        }
        catch(IOException e){
            System.out.println("Property could not be loaded");
            e.printStackTrace();
        }

        return DriverManager.getConnection(url,user,password);
    }
}