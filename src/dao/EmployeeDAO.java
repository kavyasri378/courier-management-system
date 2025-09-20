package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import util.DBConnection;
import model.Employee;

public class EmployeeDAO {

    // Add a new employee
    public void addEmployee(Employee e) {
        String sql = "INSERT INTO Employee(emp_id, emp_name, role, branch_id) VALUES(?,?,?,?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) 
        {
            pst.setInt(1, e.getEmpId());
            pst.setString(2, e.getEmp_name());
            pst.setString(3, e.getRole());
            pst.setInt(4, e.getBranch_id());
            pst.executeUpdate();
            System.out.println("Employee details are Added Successfully");
        } catch (Exception ex)
        {
            System.out.println(ex);
        }
    }

    // Update employee by ID
    public void updateEmployee(Employee e) {
        String sql = "UPDATE Employee SET emp_name=?, role=?, branch_id=? WHERE emp_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setString(1, e.getEmp_name());
            pst.setString(2, e.getRole());
            pst.setInt(3, e.getBranch_id());
            pst.setInt(4, e.getEmpId());
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee Updated successfully");
            else System.out.println("Employee not found");
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int emp_id) {
        String sql = "DELETE FROM Employee WHERE emp_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, emp_id);
            int rows = pst.executeUpdate();
            if (rows > 0) System.out.println("Employee Deleted successfully");
            else System.out.println("Employee not found");
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
    }

    // Get employee by ID
    public Employee getEmployeeById(int emp_id) {
        String sql = "SELECT * FROM Employee WHERE emp_id=?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            pst.setInt(1, emp_id);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                return new Employee(rs.getInt("emp_id"),
                    rs.getString("emp_name"),rs.getString("role"),
                    rs.getInt("branch_id"));
            }
        } 
        catch (Exception ex)
         {
            System.out.println(ex);
        }
        return null;
    }

    // Get all employees
    public List<Employee> getAllEmployees() {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM Employee";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pst = conn.prepareStatement(sql)) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Employee(rs.getInt("emp_id"),
                  rs.getString("emp_name"), rs.getString("role"),
                                      rs.getInt("branch_id")));
            }
        } 
        catch (Exception ex) 
        {
            System.out.println(ex);
        }
        return list;
    }
}
