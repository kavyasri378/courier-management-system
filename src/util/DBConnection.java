package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // Load Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // DB URL
            String url = "jdbc:mysql://localhost:3306/courierdb?useSSL=false&serverTimezone=UTC";
            String user = "root";
            String password = "Kavya@2006Kavya";
            // Connection
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection Successful!");

        } catch (Exception e) {
            System.out.println("Connection Failed: " + e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
