package model;

public class Courier {
    private int courierId;
    private String description;
    private double weight;
    private String status;
    private int customerId;
    private int branchId;

    public Courier(int courierId, String description, double wt, String stus, int customerId, int branchId)
     {
        this.courierId = courierId;
        this.description = description;
        this.weight = wt;
        this.status = stus;
        this.customerId = customerId;
        this.branchId = branchId;
    }

    // Getters and Setters 
    public int getCourierId()
     { 
        return courierId; 
    }
    public void setCourierId(int courier_id) 
    { 
        this.courierId = courier_id; 
    }

    public String getDescription()
     { 
        return description;
     }
    public void setDescription(String description) 
    { 
        this.description = description;
    }

    public double getWeight()
     { 
        return weight;
     }
    public void setWeight(double wt) 
    { 
        this.weight = wt; 
    }

    public String getStatus() 
    { 
        return status;
     }
    public void setStatus(String stus) 
    { 
        this.status = stus; 
    }

    public int getCustomer_id() 
    { 
        return customerId; 
    }
    public void setCustomer_id(int customer_id)
     { 
        this.customerId = customer_id; 
    }

    public int getBranch_id() 
    { 
        return branchId; 
    }
    public void setBranch_id(int bran_id) 
    { 
        this.branchId = bran_id; 
    }
}
