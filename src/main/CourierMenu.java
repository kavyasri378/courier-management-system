package main;

import java.util.Scanner;
import java.util.List;
import dao.*;
import model.*;

public class MainMenu {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // DAO objects
        CustomerDAO custDao = new CustomerDAO();
        CourierDAO courierDao = new CourierDAO();
        BranchDAO branchDao = new BranchDAO();
        EmployeeDAO empDao = new EmployeeDAO();
        PaymentDAO payDao = new PaymentDAO();

        while (true) {
            System.out.println("\n=== Courier Management System Main Menu ===");
            System.out.println("1. Customer Menu");
            System.out.println("2. Courier Menu");
            System.out.println("3. Branch Menu");
            System.out.println("4. Employee Menu");
            System.out.println("5. Payment Menu");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 0:
                    System.out.println("Thank you! Exiting CMS...");
                    sc.close();
                    return;

                // ===== Customer Menu =====
                case 1:
                    System.out.println("\n-- Customer Menu --");
                    System.out.println("1. Add Customer");
                    System.out.println("2. Update Customer");
                    System.out.println("3. Delete Customer");
                    System.out.println("4. View Customer by ID");
                    System.out.println("5. View All Customers");
                    System.out.print("Choice: ");
                    int custChoice = sc.nextInt(); sc.nextLine();

                    if(custChoice == 1) {
                        System.out.print("Enter Customer ID: "); int cid = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Name: "); String cname = sc.nextLine();
                        System.out.print("Enter Phone: "); String cphone = sc.nextLine();
                        System.out.print("Enter Address: "); String caddr = sc.nextLine();
                        System.out.print("Enter Email: "); String cemail = sc.nextLine();
                        custDao.addCustomer(new Customer(cid, cname, cphone, caddr, cemail));
                        System.out.println("Customer added successfully!");
                    } else if(custChoice == 2) {
                        System.out.print("Enter Customer ID to update: "); int cid = sc.nextInt(); sc.nextLine();
                        System.out.print("Enter Name: "); String cname = sc.nextLine();
                        System.out.print("Enter Phone: "); String cphone = sc.nextLine();
                        System.out.print("Enter Address: "); String caddr = sc.nextLine();
                        System.out.print("Enter Email: "); String cemail = sc.nextLine();
                        custDao.updateCustomer(new Customer(cid, cname, cphone, caddr, cemail));
                        System.out.println("Customer updated if exists.");
                    } else if(custChoice == 3) {
                        System.out.print("Enter Customer ID to delete: "); int cid = sc.nextInt(); sc.nextLine();
                        custDao.deleteCustomer(cid);
                    } else if(custChoice == 4) {
                        System.out.print("Enter Customer ID to view: "); int cid = sc.nextInt(); sc.nextLine();
                        Customer c = custDao.getCustomerById(cid);
                        if(c != null) {
                            System.out.println("ID: "+c.getCustomerId()+", Name: "+c.getName()+", Phone: "+c.getPhone()+", Address: "+c.getAddress()+", Email: "+c.getEmail());
                        } else {
                            System.out.println("Customer not found!");
                        }
                    } else if(custChoice == 5) {
                        List<Customer> allCust = custDao.getAllCustomers();
                        System.out.println("All Customers:");
                        for(Customer c : allCust) {
                            System.out.println(c.getCustomerId()+" | "+c.getName()+" | "+c.getPhone()+" | "+c.getAddress()+" | "+c.getEmail());
                        }
                    } else {
                        System.out.println("Invalid choice, try again!");
                    }
                    break;

                // ===== Courier Menu =====
                case 2:
                    System.out.println("\n-- Courier Menu --");
                    System.out.println("1. Add Courier");
                    System.out.println("2. Update Courier");
                    System.out.println("3. Delete Courier");
                    System.out.println("4. View Courier by ID");
                    System.out.println("5. View All Couriers");
                    System.out.print("Choice: ");
                    int coChoice = sc.nextInt(); sc.nextLine();

                    if(coChoice == 1) {
                        System.out.print("Courier ID: "); int coid = sc.nextInt(); sc.nextLine();
                        System.out.print("Description: "); String desc = sc.nextLine();
                        System.out.print("Weight: "); double w = sc.nextDouble(); sc.nextLine();
                        System.out.print("Status: "); String st = sc.nextLine();
                        System.out.print("Customer ID: "); int cid = sc.nextInt(); sc.nextLine();
                        System.out.print("Branch ID: "); int bid = sc.nextInt(); sc.nextLine();
                        courierDao.addCourier(new Courier(coid, desc, w, st, cid, bid));
                        System.out.println("Courier added!");
                    } else if(coChoice == 2) {
                        System.out.print("Courier ID to update: "); int coid = sc.nextInt(); sc.nextLine();
                        System.out.print("Description: "); String desc = sc.nextLine();
                        System.out.print("Weight: "); double w = sc.nextDouble(); sc.nextLine();
                        System.out.print("Status: "); String st = sc.nextLine();
                        System.out.print("Customer ID: "); int cid = sc.nextInt(); sc.nextLine();
                        System.out.print("Branch ID: "); int bid = sc.nextInt(); sc.nextLine();
                        courierDao.updateCourier(new Courier(coid, desc, w, st, cid, bid));
                    } else if(coChoice == 3) {
                        System.out.print("Courier ID to delete: "); int coid = sc.nextInt(); sc.nextLine();
                        courierDao.deleteCourier(coid);
                    } else if(coChoice == 4) {
                        System.out.print("Courier ID to view: "); int coid = sc.nextInt(); sc.nextLine();
                        Courier c = courierDao.getCourierById(coid);
                        if(c != null) {
                            System.out.println("ID: "+c.getCourierId()+" | "+c.getDescription()+" | "+c.getWeight()+" | "+c.getStatus()+" | CustID: "+c.getCustomer_id()+" | BranchID: "+c.getBranch_id());
                        } else System.out.println("Courier not found!");
                    } else if(coChoice == 5) {
                        List<Courier> allCo = courierDao.getAllCouriers();
                        System.out.println("All Couriers:");
                        for(Courier c : allCo) {
                            System.out.println(c.getCourierId()+" | "+c.getDescription()+" | "+c.getWeight()+" | "+c.getStatus()+" | CustID: "+c.getCustomer_id()+" | BranchID: "+c.getBranch_id());
                        }
                    } else System.out.println("Invalid choice!");
                    break;

                // ===== Branch Menu =====
                case 3:
                    System.out.println("\n-- Branch Menu --");
                    System.out.println("1. Add Branch");
                    System.out.println("2. Update Branch");
                    System.out.println("3. Delete Branch");
                    System.out.println("4. View Branch by ID");
                    System.out.println("5. View All Branches");
                    System.out.print("Choice: ");
                    int bChoice = sc.nextInt(); sc.nextLine();

                    if(bChoice == 1) {
                        System.out.print("Branch ID: "); int bid = sc.nextInt(); sc.nextLine();
                        System.out.print("Branch Name: "); String bname = sc.nextLine();
                        System.out.print("Location: "); String loc = sc.nextLine();
                        branchDao.addBranch(new Branch(bid, bname, loc));
                        System.out.println("Branch added!");
                    } else if(bChoice == 2) {
                        System.out.print("Branch ID to update: "); int bid = sc.nextInt(); sc.nextLine();
                        System.out.print("Branch Name: "); String bname = sc.nextLine();
                        System.out.print("Location: "); String loc = sc.nextLine();
                        branchDao.updateBranch(new Branch(bid, bname, loc));
                    } else if(bChoice == 3) {
                        System.out.print("Branch ID to delete: "); int bid = sc.nextInt(); sc.nextLine();
                        branchDao.deleteBranch(bid);
                    } else if(bChoice == 4) {
                        System.out.print("Branch ID to view: "); int bid = sc.nextInt(); sc.nextLine();
                        Branch b = branchDao.getBranchById(bid);
                        if(b != null) System.out.println(b.getBranchId()+" | "+b.getBranchName()+" | "+b.getLocation());
                        else System.out.println("Branch not found!");
                    } else if(bChoice == 5) {
                        List<Branch> allB = branchDao.getAllBranches();
                        System.out.println("All Branches:");
                        for(Branch b : allB) System.out.println(b.getBranchId()+" | "+b.getBranchName()+" | "+b.getLocation());
                    } else System.out.println("Invalid choice!");
                    break;

                // ===== Employee Menu =====
                case 4:
                    System.out.println("\n-- Employee Menu --");
                    System.out.println("1. Add Employee");
                    System.out.println("2. Update Employee");
                    System.out.println("3. Delete Employee");
                    System.out.println("4. View Employee by ID");
                    System.out.println("5. View All Employees");
                    System.out.print("Choice: ");
                    int eChoice = sc.nextInt(); sc.nextLine();

                    if(eChoice == 1) {
                        System.out.print("Emp ID: "); int eid = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String ename = sc.nextLine();
                        System.out.print("Role: "); String role = sc.nextLine();
                        System.out.print("Branch ID: "); int bid = sc.nextInt(); sc.nextLine();
                        empDao.addEmployee(new Employee(eid, ename, role, bid));
                        System.out.println("Employee added!");
                    } else if(eChoice == 2) {
                        System.out.print("Emp ID to update: "); int eid = sc.nextInt(); sc.nextLine();
                        System.out.print("Name: "); String ename = sc.nextLine();
                        System.out.print("Role: "); String role = sc.nextLine();
                        System.out.print("Branch ID: "); int bid = sc.nextInt(); sc.nextLine();
                        empDao.updateEmployee(new Employee(eid, ename, role, bid));
                    } else if(eChoice == 3) {
                        System.out.print("Emp ID to delete: "); int eid = sc.nextInt(); sc.nextLine();
                        empDao.deleteEmployee(eid);
                    } else if(eChoice == 4) {
                        System.out.print("Emp ID to view: "); int eid = sc.nextInt(); sc.nextLine();
                        Employee e = empDao.getEmployeeById(eid);
                        if(e != null) System.out.println(e.getEmpId()+" | "+e.getEmp_name()+" | "+e.getRole()+" | "+e.getBranch_id());
                        else System.out.println("Employee not found!");
                    } else if(eChoice == 5) {
                        List<Employee> allE = empDao.getAllEmployees();
                        System.out.println("All Employees:");
                        for(Employee e : allE) System.out.println(e.getEmpId()+" | "+e.getEmp_name()+" | "+e.getRole()+" | "+e.getBranch_id());
                    } else System.out.println("Invalid choice!");
                    break;

                // ===== Payment Menu =====
                case 5:
                    System.out.println("\n-- Payment Menu --");
                    System.out.println("1. Add Payment");
                    System.out.println("2. Update Payment Status");
                    System.out.println("3. Delete Payment");
                    System.out.println("4. View Payment by ID");
                    System.out.println("5. View All Payments");
                    System.out.print("Choice: ");
                    int pChoice = sc.nextInt(); sc.nextLine();

                    if(pChoice == 1) {
                        System.out.print("Payment ID: "); int pid = sc.nextInt(); sc.nextLine();
                        System.out.print("Courier ID: "); int coid = sc.nextInt(); sc.nextLine();
                        System.out.print("Amount: "); double amt = sc.nextDouble(); sc.nextLine();
                        System.out.print("Mode: "); String mode = sc.nextLine();
                        System.out.print("Status: "); String st = sc.nextLine();
                        payDao.addPayment(new Payment(pid, coid, amt, mode, st));
                        System.out.println("Payment added!");
                    } else if(pChoice == 2) {
                        System.out.print("Payment ID: "); int pid = sc.nextInt(); sc.nextLine();
                        System.out.print("New Status: "); String st = sc.nextLine();
                        payDao.updatePaymentStatus(pid, st);
                    } else if(pChoice == 3) {
                        System.out.print("Payment ID to delete: "); int pid = sc.nextInt(); sc.nextLine();
                        payDao.deletePayment(pid);
                    } else if(pChoice == 4) {
                        System.out.print("Payment ID to view: "); int pid = sc.nextInt(); sc.nextLine();
                        Payment p = payDao.getPaymentById(pid);
                        if(p != null) System.out.println(p.getPayment_id()+" | "+p.getCourier_id()+" | "+p.getAmount()+" | "+p.getMode()+" | "+p.getStatus());
                        else System.out.println("Payment not found!");
                    } else if(pChoice == 5) {
                        List<Payment> allP = payDao.getAllPayments();
                        System.out.println("All Payments:");
                        for(Payment p : allP) System.out.println(p.getPayment_id()+" | "+p.getCourier_id()+" | "+p.getAmount()+" | "+p.getMode()+" | "+p.getStatus());
                    } else System.out.println("Invalid choice!");
                    break;

                default:
                    System.out.println("Oops! Invalid main menu choice, try again.");
            }
        }
    }
}
