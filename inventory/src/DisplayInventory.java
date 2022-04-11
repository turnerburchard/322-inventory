import java.util.ArrayList;
//Brady 4/5
public class DisplayInventory {
    public static void display(Inventory inv) {
        //create an arraylist of our current inventory of products
        ArrayList<Product> inventory = inv.inventory;

        System.out.printf("%-30s %-30s %8s %8s %-15s %3s\n", "Product Name", "Product Description", "Price", "Stock", "Active Product?" , "ID");

        //runs through the inventory and prints out product information
        for(Product p: inventory) {
            String tempName;
            String tempDesc;
            String tempActive;
            String tempStock;
            //If name/desc is longer than 30 chars, will cut them off at 27 and add 3 dots.
            if(p.getName().length() > 30) {
                tempName = p.getName().substring(0, 26);
                tempName = tempName + "...";
            }
            else {
                tempName = p.getName();
            }
            if(p.getDescription().length() > 30) {
                tempDesc = p.getDescription().substring(0, 26);
                tempDesc = tempDesc + "...";
            }
            else {
                tempDesc = p.getDescription();
            }
            if(p.getActive()) {
                tempActive = "Active";
            }
            else {
                tempActive = "Not Active";
            }
            tempStock = Integer.toString(p.getStock());
            //Print out inventory list.

            System.out.printf("%-30s %-30s %8s %8s %-15s  %s\n", tempName, tempDesc, p.getPrice(), tempStock, tempActive, p.getId());
        }
    }
}