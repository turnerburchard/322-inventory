import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface { // class drives the system
    // passes 'control' of system function to system modules that encapsulate respective system functions

    private Inventory inventory = Inventory.getInstance(); // creates/grabs inventory instance when class is init.

    public Modules currentModule = null; // var for interacting with interface methods of module classes

    public UserInterface() throws IOException { // loads .csv upon creation, essentially loading persistent data on start
        // calls menuMain() to act as class driver
        File file = new File("invData.csv");

        FileReader reader = new FileReader(file); // creates files readers
        BufferedReader buffReader = new BufferedReader(reader);

        String line = ""; // needed for reading in csv
        String [] temp; // needed for reading in csv

        int productCounter = -1;

        while((line = buffReader.readLine()) != null) {
            temp = line.split(",");

            if (productCounter >= 0) {
                Product newProd = new Product(temp[0]);

                newProd.setName(temp[1]);
                newProd.setPrice(Double.parseDouble(temp[2]));
                newProd.setDescription(temp[3]);
                if (temp[4] == "t") {
                    newProd.setActive(true);
                }
                else {
                    newProd.setActive(false);
                }

                newProd.setStock(Integer.parseInt(temp[5]));
            }
            else {
            }

            productCounter++;
        }

        System.out.println("====| " + productCounter + " products loaded into inventory |====");

        menuMain();
    }

    public void runCurrentModule() { // for running the module, used by menuMain()
        currentModule.moduleDriver(); // calls current module's driver to start that respective function
    }

    public void changeModule(Modules nextModule) { // used by menuMain() to change system function modules depending on user input
        // can also be called and used by system module if modules would like to redirect to other modules

        currentModule = nextModule; // changes system function
    }

    public void menuMain() throws IOException { // acts as a central hub for the system interface, directs to system functions
        System.out.println("====| Menu |====" + // displays main menu options to user
                "\n1 -> Add a Product" +
                "\n2 -> Search by ID" +
                "\n3 -> Edit a Product" +
                "\n4 -> Display Inventory" +
                "\n0 -> SAVE & EXIT");

        Scanner str = new Scanner(System.in); // creates scanner object

        System.out.println(">>>>| Enter Menu #: "); // visual flag for user input

        String inputString = str.nextLine(); // takes whatever user enters, so as not to create error
        // input errors caught at end of if/else

        if (inputString.equals("0")) { // SAVE & EXIT
            System.out.println("====| Saving... |====");

//            File persistData = new File("invData.csv");
//
//            if (persistData.delete()) { // deletes old invData.csv
//            }
//            else {
//                System.out.println("====| NO CHANGES SAVED: issues saving data |====");
//            }
//
//            if (persistData.createNewFile()) { // creates new, blank invData.csv
//            }
//            else {
//                System.out.println("====| NO CHANGES SAVED: issues saving data |====");
//            }

            // need code to write all inv products to invData.csv

            System.out.println("====| Closing... |====");
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

        } else if (inputString.equals("4")) {
            Inventory inventory = Inventory.getInstance();
            DisplayInventory inventoryDisplay = new DisplayInventory();
            inventoryDisplay.display(inventory);
            menuMain();
        }
        else {
            System.out.println("==== Input Not Understood -> Try Again ===="); // user input error-catcher

            menuMain(); // loops menuMain()
        }
    }

    public static void main(String[] args) throws IOException {
        new UserInterface();
    }
}

//    public static void menu(Inventory inv) {
//        System.out.println("Menu:\nEnter 1 to add a product\nEnter 2 to search for a product\nEnter 3 to modify an object\nEnter 4 to display the inventory\nEnter 0 to exit");
//        Scanner inp = new Scanner(System.in);
//        Scanner str = new Scanner(System.in);
//        Inventory inventory = inv;
//        int option = inp.nextInt();
//        while(option != 0) {
//            if(option == 1) {
//                Product p = new Product();
//                System.out.println("Enter Product Information separated by a comma:\n" +
//                        "Name, Price, Description, Stock,and Active Status(True or False)");
//                String[] line;
//                line = str.nextLine().split(",");
//                p.setName(line[0]);
//                p.setPrice(Double.parseDouble(line[1]));
//                p.setDescription(line[2]);
//                p.setStock(Integer.parseInt(line[3]));
//                p.setActive(Boolean.parseBoolean(line[4]));
//                inventory.addProduct(p);
//            }
//
//            if(option == 2) {  //ES: Option to search for an item.
//                System.out.println("Enter the first few character of a product's name to get a list of matching products.");
//                String userInput = str.nextLine();
//                userInput = userInput.toLowerCase();
//                ArrayList<Product> matchesFound = inventory.searchInventory(userInput);  //  Search inventory and compare each product to the user's input
//
//                //  Loop through and print each product that was found from the searchInventory method
//                System.out.println("Size:" +matchesFound.size());
//                for(int i = 0; i < matchesFound.size(); i++) {
//                    System.out.println(i + ":" + matchesFound.get(i).getName() + ", $" + matchesFound.get(i).getPrice() + ", #" + matchesFound.get(i).getId());
//                }
//
//
//            }
//
//            if(option == 3) {  //ES: Option to modify a Product.
//                Product modifiedProduct = new Product();
//                System.out.println("Enter the item name you would like to modify");
//                String userInput = str.nextLine().toLowerCase();
//                Product productMatch = inventory.searchForProduct(userInput);
//
//                if (productMatch == null) {  // If the product wasn't found in the search
//                }
//                //  If product is not null then we get the new info for the product and change it.
//                else {
//                    System.out.println("Enter the new info for " + productMatch.getName() + " separated by a comma\n" +
//                            "Name, Price, Description, Stock,and Active Status(True or False)");
//                    String[] line;
//                    line = str.nextLine().split(",");
//                    productMatch.setName(line[0]);
//                    productMatch.setPrice(Double.parseDouble(line[1]));
//                    productMatch.setDescription(line[2]);
//                    productMatch.setStock(Integer.parseInt(line[3]));
//                    productMatch.setActive(Boolean.parseBoolean(line[4]));
//                }
//            }
//            if(option == 4) {
//                DisplayInventory.display(inventory);
//            }
//
//            //DisplayInventory.display(inventory);
//            System.out.println("\nMenu:\nEnter 1 to add a product\nEnter 2 to search for a product\nEnter 3 to modify an object\nEnter 4 to display the inventory\nEnter 0 to exit");
//            option = inp.nextInt();
//        }
//        System.out.println("Operation complete. Closing Menu.");
//    }

