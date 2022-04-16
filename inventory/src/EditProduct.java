import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

// Written by:
// Reviewed by:

public class EditProduct extends Modules { // system function, edits an already existing Product in inventory

    public void moduleDriver() throws IOException { // driver module
        userOptions();
        userInput();
        try {
            returnToMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void userOptions() { // displays module's main menu
        System.out.println("Enter the name of a product to modify: ");
    }

    public void userInput() throws IOException { // handles module's main menu input
        Scanner name = new Scanner(System.in);
        String userInput = name.nextLine();
        ArrayList<Product> inv;
        String matchFound = "null";
        String newId = "none";

        Inventory inventory = Inventory.getInstance();
        inv = inventory.returnInventorySec();

        for(Product p : inv){ // search for product with same name
            if(p.getName().toLowerCase().equals(userInput.toLowerCase())){
                newId = p.getId();
                matchFound = "Found";
            }
        }
        if(matchFound == "null"){ // no product with input name
            System.out.println("No product with the name " + userInput);
        }
        else{ // modify the product
            System.out.println("Enter the new info for " + userInput + " separated by a comma\n" +
                               "Name, Price, Description, Stock, and Active Status(True or False)");

            String[] productInfo;
            Scanner mod = new Scanner(System.in);
            Product p = new Product(newId);

            productInfo = mod.nextLine().split(",");
            p.setName(productInfo[0]);
            p.setPrice(Double.parseDouble(productInfo[1]));
            p.setDescription(productInfo[2]);
            p.setStock(Integer.parseInt(productInfo[3]));
            p.setActive(Boolean.parseBoolean(productInfo[4]));
            inventory.modProductSec(p);

        }

    }

}
