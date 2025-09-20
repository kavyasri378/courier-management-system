package model;

public class Employee {
    private int empId;
    private String empName;
    private String role;
    private int branchId;

    public Employee(int e_id, String e_name, String role, int branchId) 
    {
        this.empId = e_id;
        this.empName = e_name;
        this.role = role;
        this.branchId = branchId;
    }

    // Getters & Setters
    public int getEmpId() 
    { 
        return empId; 
    }
    public void setEmp_id(int emp_id)
     { 
        this.empId = emp_id; 
    }

    public String getEmp_name() 
    { 
        return empName; 
    }
    public void setEmp_name(String emp_name) 
    { 
        this.empName = emp_name;
     }

    public String getRole() 
    { 
        return role; 
    }
    public void setRole(String role) 
    { 
        this.role = role; 
    }

    public int getBranch_id() 
    { 
        return branchId;
     }
    public void setBranch_id(int br_id) 
    { 
        this.branchId = br_id; 
    }
}
