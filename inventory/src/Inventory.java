import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
//Brady Ash 4/4
public class Inventory { // class that manages ArrayList of Products (i.e. the inventory)

    private static Inventory inventoryInstance;
    private static ArrayList<Product> inventory; // the aforementioned inventory

    private Inventory() { // called by getInstance(), Singleton pattern
        inventory = new ArrayList<>();
    }

    //for csv input
    Inventory(File file) throws FileNotFoundException { // prolly want to remove/move to a module?
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

    public static Inventory getInstance() { // for Singleton pattern, calls private constructor
        if (inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }
        return inventoryInstance;
    }

    public boolean addProductSec(Product prod) { // for protecting data-accessing methods
        inventory.add(prod);
        return true;
    }

    public boolean addProduct(Product prod) { // adds given product to inventory ArrayList
        addProductSec(prod);
        return true;
    }

    public Product searchForSec(String id) { // for protecting data-accessing methods

        return new Product(); // have 'null' Product constructor for passing 'not found' message to modules?
    }

    private Product searchFor(String id) { // searches for Product, given id, returns the Product

        return new Product(); // have 'null' Product constructor for passing 'not found' message to modules?
    }

    public boolean modProductSec(String id) {  // for protecting data-accessing methods

        return true;
    }

    private boolean modProduct(String id) { // modifies Product, given id

        return true;
    }

    /***
     * Ezra Skoog
     * @param userInput  - The string the user passes to search for an item
     * @return           - Returns an array list with all the products the matched the search.
     * ************************************
     * Search through the inventory and check if any product matches the user's input.
     */
    public ArrayList<Product> searchInventory(String userInput) { // should adapt/use for generic inventory iterator method
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

    /***
     * Ezra Skoog
     * @param userInput    - A string the user will pass in to search for an item to modify
     * @return Product     - Returns the product if found and NULL if the product is not found
     */
    public Product searchForProduct(String userInput) { //
        Product productMatch = null;
        boolean wasProductFound = false;

        for(Product eachProduct : inventory) {
            String tempProduct = eachProduct.getName().toLowerCase();
            if(tempProduct.equals(userInput)) {
                productMatch = eachProduct;
                wasProductFound = true;
            }
        }
        //  Check if the product was found
        //  If not then return null and display the names of all product in the inventory.
        if(wasProductFound == false) {
            int counter = 0;
            System.out.println("Product was not found. Please select one of the available product.");
            for (Product eachProduct : inventory) {
                System.out.println(counter + ": " + eachProduct.getName());
            }
        }
        return productMatch;
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
    public ArrayList getInventory() {
        return inventory;
    }
}