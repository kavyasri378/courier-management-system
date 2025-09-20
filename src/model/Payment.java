package model;

public class Payment {
    private int payment_id;
    private int courier_id;
    private double amount;
    private String mode;
    private String status;

    public Payment(int payment_id, int courier_id, double amount, String mode, String status) {
        this.payment_id = payment_id;
        this.courier_id = courier_id;
        this.amount = amount;
        this.mode = mode;
        this.status = status;
    }

    // Getters & Setters
    public int getPayment_id() { return payment_id; }
    public void setPayment_id(int payment_id) { this.payment_id = payment_id; }

    public int getCourier_id() { return courier_id; }
    public void setCourier_id(int courier_id) { this.courier_id = courier_id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
