package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.Courier;

public class CourierDAO {

    // Add a new courier
    public void addCourier(Courier c) {
        String sql = "INSERT INTO Courier(courier_id, description, weight, status, customer_id, branch_id) VALUES(?,?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, c.getCourier_id());
            pst.setString(2, c.getDescription());
            pst.setDouble(3, c.getWeight());
            pst.setString(4, c.getStatus());
            pst.setInt(5, c.getCustomer_id());
            pst.setInt(6, c.getBranch_id());
            pst.executeUpdate();
            System.out.println("Courier Added");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update courier by ID
    public void updateCourier(Courier c) {
        String sql = "UPDATE Courier SET description=?, weight=?, status=?, customer_id=?, branch_id=? WHERE courier_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, c.getDescription());
            pst.setDouble(2, c.getWeight());
            pst.setString(3, c.getStatus());
            pst.setInt(4, c.getCustomer_id());
            pst.setInt(5, c.getBranch_id());
            pst.setInt(6, c.getCourier_id());
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Courier Updated");
            else System.out.println("Courier not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete courier by ID
    public void deleteCourier(int courier_id) {
        String sql = "DELETE FROM Courier WHERE courier_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, courier_id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Courier Deleted");
            else System.out.println("Courier not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Get courier by ID
    public Courier getCourierById(int courier_id) {
        String sql = "SELECT * FROM Courier WHERE courier_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, courier_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Courier(rs.getInt("courier_id"),
                                   rs.getString("description"),
                                   rs.getDouble("weight"),
                                   rs.getString("status"),
                                   rs.getInt("customer_id"),
                                   rs.getInt("branch_id"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Get all couriers
    public List<Courier> getAllCouriers() {
        List<Courier> list = new ArrayList<>();
        String sql = "SELECT * FROM Courier";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Courier(rs.getInt("courier_id"),
                                     rs.getString("description"),
                                     rs.getDouble("weight"),
                                     rs.getString("status"),
                                     rs.getInt("customer_id"),
                                     rs.getInt("branch_id")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
