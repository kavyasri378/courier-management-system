package dao;

import java.sql.*;
import util.DBConnection;
import model.Employee;

public class EmployeeDAO {
    public void addEmployee(Employee e) {
        String sql = "INSERT INTO Employee(emp_id,emp_name,role,branch_id) VALUES(?,?,?,?)";
        try(Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, e.getEmp_id());
            pst.setString(2, e.getEmp_name());
            pst.setString(3, e.getRole());
            pst.setInt(4, e.getBranch_id());
            pst.executeUpdate();
            System.out.println("✅ Employee Added");
        } catch(Exception ex){ System.out.println(ex); }
    }
}
