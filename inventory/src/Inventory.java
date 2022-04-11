import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//Brady Ash 4/4
public class Inventory {
    ArrayList<Product> inventory;

    Inventory(){
        inventory = new ArrayList<>();
    }

    //for csv input
    Inventory(File file) throws FileNotFoundException {
        inventory = new ArrayList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            Product p = new Product();
            String[] line = scan.nextLine().split(",");
            p.setName(line[0]);
            p.setPrice(Double.parseDouble(line[1]));
            p.setDescription(line[2]);
            p.setStock(Integer.parseInt(line[3]));
            p.setActive(Boolean.parseBoolean(line[4]));
            inventory.add(p);
        }
        scan.close();
    }
    public void addProduct(Product p) {
        inventory.add(p);
    }

    /***
     * Ezra Skoog
     * @param userInput  - The string the user passes to search for an item
     * @return           - Returns an array list with all the products the matched the search.
     * ************************************
     * Search through the inventory and check if any product matches the user's input.
     */
    public ArrayList<Product> searchInventory(String userInput) {
        ArrayList<Product> matchesFound = new ArrayList<>();
        for(Product eachProduct : inventory) {  //  Check each item in the inventory to see if it contains matching letters with user input
            String tempProduct = eachProduct.getName();
            tempProduct = tempProduct.toLowerCase();
            if(tempProduct.contains(userInput)) {
                matchesFound.add(eachProduct);
            }
        }
        return matchesFound;
    }

    public void importProducts(File file) throws FileNotFoundException {
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            Product p = new Product();
            String[] line = scan.nextLine().split(",");
            p.setName(line[0]);
            p.setPrice(Double.parseDouble(line[1]));
            p.setDescription(line[2]);
            p.setStock(Integer.parseInt(line[3]));
            p.setActive(Boolean.parseBoolean(line[4]));
            inventory.add(p);
        }
        scan.close();
    }
}