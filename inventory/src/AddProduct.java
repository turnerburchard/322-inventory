import java.io.IOException;
import java.util.Scanner;

// Written by: Josh
// Reviewed by: Brady
public class AddProduct extends Modules { // system function, adds a Product to inventory

    public void moduleDriver() throws IOException { // drives module function
        userInput();
        try {
            returnToMain();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void userOptions() throws IOException { // displays module's main menu
        System.out.println("1 -> Add Product " + "\n2 -> Exit to Main Menu"); // Menu
        Scanner str = new Scanner(System.in); // creates scanner object
        String inputString = str.nextLine(); // takes whatever user enters, so as not to create error
        if(inputString.equals("1")){ // Add product
            userInput();
        }
        else{ // exit to main
            returnToMain();
        }

    }


    public void userInput() throws IOException { // handles module's main menu input
        Scanner n = new Scanner(System.in);
        Scanner p = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        Scanner a = new Scanner(System.in);
        Scanner i = new Scanner(System.in);

        System.out.println(">>>> Enter ID: "); // take id from user
        String id = i.nextLine();

        System.out.println(">>>> Enter Name: ");
        String name = n.nextLine(); // take name from user

        System.out.println(">>>> Enter Price: ");
        Double price = 0.0;
        try{
            price = p.nextDouble(); // take price from user
        }
        catch(Exception e){ // if input is not a double
            System.out.println("====| WRONG INPUT: ");
            userOptions();
            return;
        }

        System.out.println(">>>> Enter Description: ");
        String description = d.nextLine(); // take description from user


        System.out.println(">>>> Enter Stock: ");
        int stock = 0;
        try{
            stock = s.nextInt(); // take stock from user
        }
        catch(Exception e){ // if input is not an int
            System.out.println("====| WRONG INPUT: ");
            userOptions();
            return;
        }

        System.out.println(">>>> Enter Active (True or False): ");
        boolean active = false;
        try{
            active = a.nextBoolean(); // take active from user
        }
        catch(Exception e){ // if input is not a boolean
            System.out.println("====| WRONG INPUT: ");
            userOptions();
            return;
        }

        Product prod = new Product(id); // set variables for the product
        prod.setName(name);
        prod.setPrice(price);
        prod.setDescription(description);
        prod.setStock(stock);
        prod.setActive(active);

        Inventory inventory = Inventory.getInstance();
        boolean add = inventory.addProductSec(prod); // add the product

        if(add == false){ // if addProductSec can't add a product
            System.out.println("====| ERROR: Product " + name + " already exist");
        }
        else{ // product was added successfully
            System.out.println("====| Product " + name + " was entered successfully");
        }
    }

}
