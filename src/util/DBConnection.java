package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    // MySQL database URL, username, password
    private static final String URL = "jdbc:mysql://localhost:3306/courierdb";
    private static final String USER = "root";      
    private static final String PASSWORD = "Kavya@2006Kavya"; 

    // Method to get connection
    public static Connection getConnection() {
        try {
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully!");
            return con;
        } catch (SQLException e) {
            System.out.println("Connection Failed: " + e.getMessage());
            return null;
        }
    }

    // Test main method
    public static void main(String[] args) {
        getConnection();
    }
}