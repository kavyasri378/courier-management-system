package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.Customer;

public class CustomerDAO 
{

    // Adding a new customer data
    public void addCustomer(Customer c) {
        String sql = "INSERT INTO Customer(customer_id, name, phone, address, email) VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) 
            {
            pst.setInt(1, c.getCustomerId());
            pst.setString(2, c.getName());
            pst.setString(3, c.getPhone());
            pst.setString(4, c.getAddress());
            pst.setString(5, c.getEmail());
            pst.executeUpdate();
            System.out.println("Customer details are Added");
        } 
        catch (Exception e) 
        {
            System.out.println("Error:"+e);
        }
    }

    // Updating customer detail by ID
    public void updateCustomer(Customer c) 
    {
        String sql = "UPDATE Customer SET name=?, phone=?, address=?, email=? WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) 
             {
            pst.setString(1, c.getName());
            pst.setString(2, c.getPhone());
            pst.setString(3, c.getAddress());
            pst.setString(4, c.getEmail());
            pst.setInt(5, c.getCustomerId());
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Customer Updated");
            else System.out.println("Customer not found");
        } 
    catch (Exception e) {
            System.out.println("Error:"+e);
        }
    }

    // Deleting customer details by ID
    public void deleteCustomer(int id) {
        String sql = "DELETE FROM Customer WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql))
         {
            pst.setInt(1, id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Customer Deleted");
            else System.out.println("Customer not found");
        } 
        catch (Exception e) 
        {
            System.out.println("Error:"+e);
        }
    }

    // displaying customer details by ID
    public Customer getCustomerById(int id) {
        String sql = "SELECT * FROM Customer WHERE customer_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) 
             
        {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) 
            {
                return new Customer(rs.getInt("customer_id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("email"));
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error:"+e);
        }
        return null;
    }

    // Geting all customers
    public List<Customer> getAllCustomers() 
    {
        List<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM Customer";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) 
             {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) 
            {
                list.add(new Customer(rs.getInt("customer_id"), rs.getString("name"),
                        rs.getString("phone"), rs.getString("address"), rs.getString("email")));
            }
        } 
        catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
