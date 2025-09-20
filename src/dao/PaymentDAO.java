package dao;

import java.sql.*;
import util.DBConnection;
import model.Payment;

public class PaymentDAO {
    public void addPayment(Payment p) {
        String sql = "INSERT INTO Payment(payment_id,courier_id,amount,mode,status) VALUES(?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, p.getPayment_id());
            pst.setInt(2, p.getCourier_id());
            pst.setDouble(3, p.getAmount());
            pst.setString(4, p.getMode());
            pst.setString(5, p.getStatus());
            pst.executeUpdate();
            System.out.println("✅ Payment Added");
        } catch(Exception e){ System.out.println(e); }
    }
}
