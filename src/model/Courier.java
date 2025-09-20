package model;

public class Courier {
    private int courier_id;
    private String description;
    private double weight;
    private String status;
    private int customer_id;
    private int branch_id;

    public Courier(int courier_id, String description, double weight, String status, int customer_id, int branch_id) {
        this.courier_id = courier_id;
        this.description = description;
        this.weight = weight;
        this.status = status;
        this.customer_id = customer_id;
        this.branch_id = branch_id;
    }

    // Getters & Setters
    public int getCourier_id() { return courier_id; }
    public void setCourier_id(int courier_id) { this.courier_id = courier_id; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getCustomer_id() { return customer_id; }
    public void setCustomer_id(int customer_id) { this.customer_id = customer_id; }

    public int getBranch_id() { return branch_id; }
    public void setBranch_id(int branch_id) { this.branch_id = branch_id; }
}
