import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

// Written by: Jeremy
// Reviewed by: Ezra

// GENERIC INVENTORY PROGRAM: by unique ID/serial #/SKU/etc.
// Created by: Brady Ash, Ezra Skoog, Jeremy Heng, Josh Fried, Turner Burchard
// This system is designed to be a generic inventory management system that stores items as Products
// ID, name, price, description, whether the Product is active, and stock count are all respectively saved for all Products
// The system provides function for displaying inventory Products, adding to inventory, and searching inventory
// The system was built using OCP principles with system functions (called Modules) being open for extension

public class UserInterface { // class drives the system, handles user input, and acts as the main menu for the system
    // passes 'control' of system function to system modules that encapsulate respective system functions
    // userInterface can be created multiple times and it will not affect system function, no need to hold to a static or single ref

    public Modules currentModule = null; // var for interacting with interface methods of module classes

    public UserInterface() throws IOException { // loads .csv upon creation, essentially loading persistent data on start
        // calls menuMain() to act as class driver

        Inventory.getInstance(); // calls constructor for inventory to load, singleton pattern so no bad effects?

        menuMain(); // displays main menu
    }

    public void runCurrentModule() throws IOException { // for running the module, used by menuMain()
        currentModule.moduleDriver(); // calls current module's driver to start that respective function
    }

    public void changeModule(Modules nextModule) { // used by menuMain() to change system function modules depending on user input
        // can also be called and used by system module if modules would like to redirect to other modules

        currentModule = nextModule; // changes system function
    }

    public void menuMain() throws IOException { // acts as a central hub for the system interface, directs to system functions
        System.out.println("====| Main Menu: " + // displays main menu options to user
                "\n1 -> Add a Product" +
                "\n2 -> Search" +
                "\n3 -> Edit a Product" +
                "\n4 -> Display Inventory" +
                "\n0 -> SAVE & EXIT");

        Scanner str = new Scanner(System.in); // creates scanner object

        System.out.println(">>>> Enter Menu #: "); // visual flag for user input

        String inputString = str.nextLine(); // takes whatever user enters, so as not to create error
        // input errors caught at end of if/else

        if (inputString.equals("0")) { // SAVE & EXIT
            System.out.println("====| Saving...");

            File persistData = new File("invData.csv");

            if (persistData.delete()) { // deletes old invData.csv
            }
            else {
                System.out.println("====| NO CHANGES SAVED: issues saving data |====1");
            }

            if (persistData.createNewFile()) { // creates new, blank invData.csv
                //sets up the writer, and writes the header to the file
                PrintWriter writer = new PrintWriter(persistData);
                ArrayList<Product> inventory = Inventory.getInstance().returnInventorySec();
                writer.append("id,name,price,description,active,stock\n");

                for (Product eachProduct : inventory) {  // prints each piece of product info into the file, adding commas in between.
                    writer.append(eachProduct.getId());
                    writer.append(",");
                    writer.append(eachProduct.getName());
                    writer.append(",");
                    writer.append(Double.toString(eachProduct.getPrice()));
                    writer.append(",");
                    writer.append(eachProduct.getDescription());
                    writer.append(",");
                    if(eachProduct.getActive()) {
                        writer.append("t");
                    }
                    else {
                        writer.append("f");
                    }
                    writer.append(",");
                    writer.append(Integer.toString(eachProduct.getStock()));
                    writer.append("\n");

                }
                writer.flush();
                writer.close();
            }
            else {
                System.out.println("====| NO CHANGES SAVED: issues saving data |====");
            }

             //need code to write all inv products to newly created invData.csv, because old invData.csv was deleted

            System.out.println("====| Closing...");
            System.exit(0);

        } else if (inputString.equals("1")) { // add a product
            changeModule(new AddProduct());

            runCurrentModule();

        } else if (inputString.equals("2")) { // search by id
            changeModule(new Search());

            runCurrentModule();

        } else if (inputString.equals("3")) { // edit a product
            changeModule(new EditProduct());

            runCurrentModule();

        } else if (inputString.equals("4")) { // displays all Products in Inventory
            changeModule(new DisplayInventory());

            runCurrentModule();

        }
        else {
            System.out.println("====| Input Not Understood -> Try Again"); // user input error-catcher

            menuMain(); // loops menuMain()
        }
    }

    public static void main(String[] args) throws IOException {
        new UserInterface();
    }
}