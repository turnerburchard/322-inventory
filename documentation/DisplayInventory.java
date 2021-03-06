import java.io.IOException;
import java.util.ArrayList;

// Written by: Jeremy
// Reviewed by: Josh

public class DisplayInventory extends Modules { // system function, displays all Products (w/ data) in inventory

    public void moduleDriver() throws IOException { // drives module's function

        ArrayList<Product> inventory = Inventory.getInstance().returnInventorySec(); // gets copy of inventory ArrayList

        System.out.println("====| Current Inventory: ");
        System.out.printf("%-8s %-15s %-30s %-30s %8s %8s %-15s\n", "Line", "ID", "Product Name", "Product Description", "Price", "Stock", "Status");

        int lineCounter = 1; // for keeping track of the line number when printing

        //runs through the inventory and prints out product information
        for (Product p : inventory) {
            String tempName;
            String tempDesc;
            String tempActive;
            String tempStock;
            //If name/desc is longer than 30 chars, will cut them off at 27 and add 3 dots
            if (p.getName().length() > 30) {
                tempName = p.getName().substring(0, 26);
                tempName = tempName + "...";
            } else {
                tempName = p.getName();
            }
            if (p.getDescription().length() > 30) {
                tempDesc = p.getDescription().substring(0, 26);
                tempDesc = tempDesc + "...";
            } else {
                tempDesc = p.getDescription();
            }
            if (p.getActive()) {
                tempActive = "Active";
            } else {
                tempActive = "Inactive";
            }
            tempStock = Integer.toString(p.getStock());

            //Prints inventory list
            System.out.printf("%-8s %-15s %-30s %-30s %8s %8s %-15s  \n", lineCounter, p.getId(), tempName, tempDesc, p.getPrice(), tempStock, tempActive);

            lineCounter++; // for increasing line number
        }

        returnToMain(); // exits module and returns to main, no user interaction w/ this module
    }
}