package model;

public class Branch 
{
    //declaring of variables
    private int branchId;
    private String branchName;
    private String location;
   //constructor
    public Branch(int branchId, String branchName, String location) 
    {
        this.branchId = branchId;
        this.branchName = branchName;
        this.location = location;
    }

    // Getters & Setters
    public int getBranchId() 
    { 
        return branchId; 
    }
    public void setBranchId(int branchId) 
    { 
        this.branchId = branchId; 
    }

    public String getBranchName() 
    { 
        return branchName;
     }
    public void setBranchName(String branchName) 
    { 
        this.branchName = branchName; 
    }

    public String getLocation()
     { 
        return location; 
    }
    public void setLocation(String loc) 
    { 
        this.location = loc;
    }
}
