package model;

public class Customer 
{
    private int customerId;
    private String name;
    private String phone;
    private String address;
    private String email;

    public Customer(int cusId, String name, String phone, String address, String email) 
    {
        this.customerId = cusId;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    // Getters & Setters
    public int getCustomerId() 
    { 
        return customerId; 
    }
    public void setCustomerId(int customer_id) 
    { 
        this.customerId = customer_id; 
    }

    public String getName() 
    { 
        return name; 
    }
    public void setName(String name) 
    { 
        this.name = name; 
    }

    public String getPhone() 
    { 
        return phone; 
    }
    public void setPhone(String phone) 
    { 
        this.phone = phone; 
    }

    public String getAddress() 
    { 
        return address; 
    }
    public void setAddress(String address) 
    { 
        this.address = address; 
    }

    public String getEmail() 
    { 
        return email; 
    }
    public void setEmail(String email) 
    { 
        this.email = email; 
    }
}
