package dao;

import java.sql.*;
import util.DBConnection;
import model.Courier;

public class CourierDAO {
    public void addCourier(Courier c) {
        String sql = "INSERT INTO Courier(courier_id,description,weight,status,customer_id,branch_id) VALUES(?,?,?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, c.getCourier_id());
            pst.setString(2, c.getDescription());
            pst.setDouble(3, c.getWeight());
            pst.setString(4, c.getStatus());
            pst.setInt(5, c.getCustomer_id());
            pst.setInt(6, c.getBranch_id());
            pst.executeUpdate();
            System.out.println("✅ Courier Added");
        } catch(Exception e){ System.out.println(e); }
    }
}
