package main;

import java.util.Scanner;
import java.util.List;
import dao.CourierDAO;
import model.Courier;

public class CourierMenu {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CourierDAO dao = new CourierDAO();

        while (true) {
            System.out.println("\n=== Courier Menu ===");
            System.out.println("1. Add Courier");
            System.out.println("2. Update Courier");
            System.out.println("3. Delete Courier");
            System.out.println("4. View Courier by ID");
            System.out.println("5. View All Couriers");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) 
            {
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                case 1:
                    System.out.print("Courier ID: "); 
                    int id = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("Description: "); 
                    String desc = sc.nextLine();
                    System.out.print("Weight: "); 
                    double w = sc.nextDouble(); 
                    sc.nextLine();
                    System.out.print("Status: "); 
                    String st = sc.nextLine();
                    System.out.print("Customer ID: "); 
                    int cid = sc.nextInt(); sc.nextLine();
                    System.out.print("Branch ID: "); 
                    int bid = sc.nextInt(); 
                    sc.nextLine();
                    dao.addCourier(new Courier(id, desc, w, st, cid, bid));
                    break;

                case 2:
                    System.out.print("Courier ID to update: "); int uid = sc.nextInt(); 
                    sc.nextLine();
                    System.out.print("ENterDescription: ");
                    String newDesc = sc.nextLine();
                    System.out.print("Enter Weight: ");
                    double newW = sc.nextDouble(); 
                    sc.nextLine();
                    System.out.print("Enter Status: "); 
                    String newSt = sc.nextLine();
                    System.out.print("Enter Customer ID: "); 
                    int newCid = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Branch ID: "); 
                    int newBid = sc.nextInt(); 
                    sc.nextLine();
                    dao.updateCourier(new Courier(uid, newDesc, newW, newSt, newCid, newBid));
                    break;

                case 3:
                    System.out.print("ENter Courier ID to delete: "); int delId = sc.nextInt(); sc.nextLine();
                    dao.deleteCourier(delId);
                    break;

                case 4:
                    System.out.print("Courier ID to view: "); int viewId = sc.nextInt(); sc.nextLine();
                    Courier c = dao.getCourierById(viewId);
                    if (c != null) {
                        System.out.println("ID: " + c.getCourierId() +
                            ", Desc: " + c.getDescription() +", Weight: " + c.getWeight() + ", Status: " + c.getStatus() +
                                 ", Customer ID: " + c.getCustomer_id() + ", Branch ID: " + c.getBranch_id());
                    } 
                    else {
                        System.out.println("Courier details are not found!");
                    }
                    break;

                case 5:
                    List<Courier> list = dao.getAllCouriers();
                    System.out.println("\nAll Couriers:");
                    for (Courier co : list) {
                        System.out.println(co.getCourierId()+" | "+co.getDescription() +" | " + co.getWeight() + " | " + co.getStatus() +
                            " | "+co.getCustomer_id()+" | "+ co.getBranch_id());
                    }
                    break;

                default:
                    System.out.println("Invalid choice Try again");
            }
        }
    }
}
