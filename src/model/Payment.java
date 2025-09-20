package model;

public class Payment {
    private int paymentId;
    private int courierId;
    private double amount;
    private String mode;
    private String status;

    public Payment(int pay_id, int courier_id, double amount, String mode, String status) {
        this.paymentId = pay_id;
        this.courierId = courier_id;
        this.amount = amount;
        this.mode = mode;
        this.status = status;
    }

    // Getters & Setters
    public int getPayment_id() 
    { 
        return paymentId; 
    }
    public void setPayment_id(int payment_id) 
    { 
        this.paymentId = payment_id; 
    
    }

    public int getCourier_id() 
    { 
        return courierId;
    }
    public void setCourier_id(int courier_id) 
    { 
        this.courierId = courier_id;
     }

    public double getAmount() 
    { 
        return amount; 
    }
    public void setAmount(double amount) 
    { 
        this.amount = amount; 
    
    }

    public String getMode() 
    { 
        return mode; 
    }
    public void setMode(String mode)
     { 
        this.mode = mode; 
    }

    public String getStatus() 
    {
         return status; 
    }
    public void setStatus(String status) 
    { 
        this.status = status;
     }
}
