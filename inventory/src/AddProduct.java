import java.io.IOException;
import java.util.Scanner;

// Written by: Josh
// Reviewed by: Brady

public class AddProduct extends Modules { // system function, adds a Product to inventory

    public void moduleDriver() throws IOException { // drives module function
        userInput();

        try { // the java IDE gods said put this in so...
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
        else if(inputString.equals("2")){ // exit to main
            returnToMain();
        }
        else{ // menu
            System.out.println("====| Input Not Understood -> Try Again");
            userOptions();
        }
    }

    public void userInput() throws IOException { // drives modules function / handles user input for Product details changes

        Scanner n = new Scanner(System.in);
        Scanner p = new Scanner(System.in);
        Scanner d = new Scanner(System.in);
        Scanner s = new Scanner(System.in);
        Scanner a = new Scanner(System.in);
        Scanner i = new Scanner(System.in);

        // take id from user
        System.out.println(">>>> Enter ID: ");
        String id = i.nextLine();

        // take name from user
        System.out.println(">>>> Enter Name: ");
        String name = n.nextLine();

        // take price from user
        System.out.println(">>>> Enter Price: ");
        Double price = 0.0;
        try{
            price = p.nextDouble();
        }
        catch(Exception e){ // if input is not a double
            System.out.println("====| Input Not Understood -> Try Again");
            userOptions();
            return;
        }

        // take description from user
        System.out.println(">>>> Enter Description: ");
        String description = d.nextLine();

        // take stock from user
        System.out.println(">>>> Enter Stock: ");
        int stock = 0;
        try{
            stock = s.nextInt();
        }
        catch(Exception e){ // if input is not an int
            System.out.println("====| Input Not Understood -> Try Again");
            userOptions();
            return;
        }

        // take active from user
        System.out.println(">>>> Enter Status (true or false): ");
        boolean active = false;
        try{
            active = a.nextBoolean();
        }
        catch(Exception e){ // if input is not a boolean
            System.out.println("====| Input Not Understood -> Try Again");
            userOptions();
            return;
        }

        // sets variables for the product
        Product prod = new Product(id);
        prod.setName(name);
        prod.setPrice(price);
        prod.setDescription(description);
        prod.setStock(stock);
        prod.setActive(active);

        // adds product to inventory
        Inventory inventory = Inventory.getInstance();
        boolean add = inventory.addProductSec(prod);

        if(add == false){ // if addProductSec can't add a product
            System.out.println("====| Product '" + id + "' already exists -> Try Again");
        }
        else{ // product was added successfully
            System.out.println("====| Product '" + id + "' was added");
        }
    }
}
