package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.Branch;

public class BranchDAO {

    // Add a new branch
    public void addBranch(Branch b) {
        String sql = "INSERT INTO Branch(branch_id, branch_name, location) VALUES(?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, b.getBranch_id());
            pst.setString(2, b.getBranch_name());
            pst.setString(3, b.getLocation());
            pst.executeUpdate();
            System.out.println("Branch Added");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update a branch by ID
    public void updateBranch(Branch b) {
        String sql = "UPDATE Branch SET branch_name=?, location=? WHERE branch_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, b.getBranch_name());
            pst.setString(2, b.getLocation());
            pst.setInt(3, b.getBranch_id());
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Branch Updated");
            else System.out.println("Branch not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Delete a branch by ID
    public void deleteBranch(int branch_id) {
        String sql = "DELETE FROM Branch WHERE branch_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, branch_id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Branch Deleted");
            else System.out.println("Branch not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Get a branch by ID
    public Branch getBranchById(int branch_id) {
        String sql = "SELECT * FROM Branch WHERE branch_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, branch_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Branch(rs.getInt("branch_id"),
                                  rs.getString("branch_name"),
                                  rs.getString("location"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    // Get all branches
    public List<Branch> getAllBranches() {
        List<Branch> list = new ArrayList<>();
        String sql = "SELECT * FROM Branch";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Branch(rs.getInt("branch_id"),
                                    rs.getString("branch_name"),
                                    rs.getString("location")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
}
