package dao;

import java.sql.*;
import util.DBConnection;
import model.Customer;

public class CustomerDAO {
    public void addCustomer(Customer c) {
        String sql = "INSERT INTO Customer(customer_id,name,phone,address,email) VALUES(?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, c.getCustomer_id());
            pst.setString(2, c.getName());
            pst.setString(3, c.getPhone());
            pst.setString(4, c.getAddress());
            pst.setString(5, c.getEmail());
            pst.executeUpdate();
            System.out.println("✅ Customer Added");
        } catch(Exception e){ System.out.println(e); }
    }

    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE customer_id=?";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if(rs.next()) return new Customer(rs.getInt("customer_id"), rs.getString("name"),
                    rs.getString("phone"), rs.getString("address"), rs.getString("email"));
        } catch(Exception e){ System.out.println(e); }
        return null;
    }
}
