import java.io.*;
import java.util.ArrayList;

// Written by: Josh
// Reviewed by: Turner

public class Inventory { // class that manages ArrayList of Products (i.e. the inventory)

    private static Inventory inventoryInstance = null;
    private static ArrayList<Product> inventory; // the aforementioned inventory

    private Inventory() throws IOException { // called by getInstance(), Singleton pattern
        inventory = new ArrayList<>(); // creates an empty inventory

        // rest of the constructor code loads persistent data from "invData.csv" into inventory
        File file = new File("invData.csv");

        // creates files readers
        FileReader reader = new FileReader(file);
        BufferedReader buffReader = new BufferedReader(reader);

        String line = ""; // needed for reading in csv
        String [] temp; // needed for reading in csv

        int productCounter = -1; // starts at -1 for handling first line headers

        while((line = buffReader.readLine()) != null) { // reads .csv
            temp = line.split(",");

            if (productCounter >= 0) { // handles first line headers
                Product newProd = new Product(temp[0]);

                newProd.setName(temp[1]);
                newProd.setPrice(Double.parseDouble(temp[2]));
                newProd.setDescription(temp[3]);

                if (temp[4].equals("t")) {
                    newProd.setActive(true);
                }
                else {
                    newProd.setActive(false);
                }

                newProd.setStock(Integer.parseInt(temp[5]));

                addProductSec(newProd); // adds Product read from .csv to inventory
            }
            else {
            }

            productCounter++; // keeps track of the # of Products being loaded
        }

        System.out.println("====| " + productCounter + " products loaded into inventory");
        reader.close();
        buffReader.close();
    }

    public static Inventory getInstance() throws IOException { // for Singleton pattern, calls private constructor
        if (inventoryInstance == null) {
            inventoryInstance = new Inventory();
        }

        return inventoryInstance;
    }

    public boolean addProductSec(Product prod) { // for protecting data-accessing methods
        return addProduct(prod);
    } // for security, calls actual method

    private boolean addProduct(Product prod) { // adds given product to inventory ArrayList
        for(Product p : inventory){ // searches for matching ids
            if(p.getId().equals(prod.getId())){ // if ids match then don't add product
                return false;
            }
        }

        inventory.add(prod); // adds product to inventory ArrayList

        return true;
    }

    public boolean modProductSec(Product prod) { // for security, calls actual method
        return modProduct(prod);
    }

    private boolean modProduct(Product prod) { // modifies already existing Product
        for(Product p : inventory) {
            if (p.getId().equals(prod.getId())) { // search for id
                p.setName(prod.getName()); // modify name
                p.setPrice(prod.getPrice()); // modify price
                p.setDescription(prod.getDescription()); // modify description
                p.setStock(prod.getStock()); // modify stock
                p.setActive(prod.getActive()); // modify active
                return true;
            }
        }

        return false;
    }

    public ArrayList<Product> returnInventorySec() { // for security, calls actual method
        return returnInventory();
    }

    private ArrayList<Product> returnInventory() { // returns a copy of the inventory for system searching functions
        // passes by value, not by ref, ensures modules don't accidentally edit Product data

        return inventory;
    }
}