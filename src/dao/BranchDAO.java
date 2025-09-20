package dao;

import java.sql.*;
import util.DBConnection;
import model.Branch;

public class BranchDAO {
    public void addBranch(Branch b) {
        String sql = "INSERT INTO Branch(branch_id,branch_name,location) VALUES(?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, b.getBranch_id());
            pst.setString(2, b.getBranch_name());
            pst.setString(3, b.getLocation());
            pst.executeUpdate();
            System.out.println("✅ Branch Added");
        } catch(Exception e){ System.out.println(e); }
    }
}
