package model;

public class Employee {
    private int emp_id;
    private String emp_name;
    private String role;
    private int branch_id;

    public Employee(int emp_id, String emp_name, String role, int branch_id) {
        this.emp_id = emp_id;
        this.emp_name = emp_name;
        this.role = role;
        this.branch_id = branch_id;
    }

    // Getters & Setters
    public int getEmp_id() { return emp_id; }
    public void setEmp_id(int emp_id) { this.emp_id = emp_id; }

    public String getEmp_name() { return emp_name; }
    public void setEmp_name(String emp_name) { this.emp_name = emp_name; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public int getBranch_id() { return branch_id; }
    public void setBranch_id(int branch_id) { this.branch_id = branch_id; }
}
