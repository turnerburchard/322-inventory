import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
//Brady Ash 4/4
public class Inventory {
    private ArrayList<Product> inventory;

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

    /***
     * Ezra Skoog
     * @param userInput    - A string the user will pass in to search for an item to modify
     * @return Product     - Returns the product if found and NULL if the product is not found
     */
    public Product searchForProduct(String userInput) {
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
}