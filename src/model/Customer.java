package model;

public class Customer {
    private int customer_id;
    private String name;
    private String phone;
    private String address;
    private String email;

    public Customer(int customer_id, String name, String phone, String address, String email) {
        this.customer_id = customer_id;
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    // Getters & Setters
    public int getCustomer_id() { return customer_id; }
    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
