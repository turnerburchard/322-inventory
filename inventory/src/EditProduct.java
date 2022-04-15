import java.util.Scanner;
import java.util.ArrayList;

public class EditProduct extends Modules {

    public void moduleDriver() {
        userOptions();
        userInput();
        returnToMain();
    }

    public void userOptions() {
        System.out.println("Enter the name of a product to modify: ");
    }

    public void userInput() {
        Scanner name = new Scanner(System.in);
        String userInput = name.nextLine().toLowerCase();
        ArrayList<Product> inv;
        String matchFound = "null";
        String newId = "none";

        Inventory inventory = Inventory.getInstance();
        inv = inventory.returnInventorySec();

        for(Product p : inv){ // search for product with same name
            if(p.getName().toLowerCase().equals(userInput)){
                newId = p.getId();
                matchFound = "Found";
            }
        }
        if(matchFound == "null"){ // no product with input name
            System.out.println("No product with the name " + name);
        }
        else{ // modify the product
            System.out.println("Enter the new info for " + name + " separated by a comma\n" +
                               "Name, Price, Description, Stock, and Active Status(True or False)");

            String[] productInfo;
            Scanner mod = new Scanner(System.in);
            Product p = new Product();

            productInfo = mod.nextLine().split(",");
            p.setName(productInfo[0]);
            p.setPrice(Double.parseDouble(productInfo[1]));
            p.setDescription(productInfo[2]);
            p.setStock(Integer.parseInt(productInfo[3]));
            p.setActive(Boolean.parseBoolean(productInfo[4]));
            p.setId(newId);
            inventory.modProductSec(p);

        }

    }

    public void returnToMain(){

    }
}
