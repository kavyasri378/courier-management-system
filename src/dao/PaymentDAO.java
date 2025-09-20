package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.Payment;

public class PaymentDAO {

    // Add a new payment
    public void addPayment(Payment p) {
        String sql = "INSERT INTO Payment(payment_id, courier_id, amount, mode, status) VALUES(?,?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, p.getPayment_id());
            pst.setInt(2, p.getCourier_id());
            pst.setDouble(3, p.getAmount());
            pst.setString(4, p.getMode());
            pst.setString(5, p.getStatus());
            pst.executeUpdate();
            System.out.println("Payment Added");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update payment status
    public void updatePaymentStatus(int payment_id, String status) {
        String sql = "UPDATE Payment SET status=? WHERE payment_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, status);
            pst.setInt(2, payment_id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Payment Status Updated");
            else System.out.println("Payment not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete payment by ID
    public void deletePayment(int payment_id) {
        String sql = "DELETE FROM Payment WHERE payment_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, payment_id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Payment Deleted");
            else System.out.println("Payment not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Get payment by ID
    public Payment getPaymentById(int payment_id) {
        String sql = "SELECT * FROM Payment WHERE payment_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, payment_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Payment(rs.getInt("payment_id"),
                                   rs.getInt("courier_id"),
                                   rs.getDouble("amount"),
                                   rs.getString("mode"),
                                   rs.getString("status"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Get all payments
    public List<Payment> getAllPayments() {
        List<Payment> list = new ArrayList<>();
        String sql = "SELECT * FROM Payment";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Payment(rs.getInt("payment_id"),
                                     rs.getInt("courier_id"),
                                     rs.getDouble("amount"),
                                     rs.getString("mode"),
                                     rs.getString("status")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
