import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    Modules currentModule = null; // when null, main menu display/options?

    public void changeModule() {

    }

    public static void main(String[] args) throws FileNotFoundException {
        Product p = new Product();
        p.setName("Turner's Fantastic Stir Fry and Cherry Pie");
        p.setPrice(19.99);
        p.setDescription("This Stir Fry and Cherry Pie evokes memories of the salty breeze off the ocean, and a warm summer day");
        //System.out.println(p.getName() + " \nPrice: " + p.getPrice() + " \nDescription: " + p.getDescription());

        File data = new File("data.csv");

        Inventory inventory = Inventory.getInstance();
        inventory.addProduct(p);

        inventory.importProducts(data);
        DisplayInventory.display(inventory);

        UserInterface.menu(inventory);
    }

    public static void menu(Inventory inv) {
        System.out.println("Menu:\nEnter 1 to add a product\nEnter 2 to search for a product\nEnter 3 to modify an object\nEnter 4 to display the inventory\nEnter 0 to exit");
        Scanner inp = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        Inventory inventory = inv;
        int option = inp.nextInt();
        while(option != 0) {
            if(option == 1) {
                AddProduct addProduct = new AddProduct();
                addProduct.moduleDriver();
            }

            if(option == 2) {  //ES: Option to search for an item.
                System.out.println("Enter the first few character of a product's name to get a list of matching products.");
                String userInput = str.nextLine();
                userInput = userInput.toLowerCase();
                ArrayList<Product> matchesFound = inventory.searchInventory(userInput);  //  Search inventory and compare each product to the user's input

                //  Loop through and print each product that was found from the searchInventory method
                System.out.println("Size:" +matchesFound.size());
                for(int i = 0; i < matchesFound.size(); i++) {
                    System.out.println(i + ":" + matchesFound.get(i).getName() + ", $" + matchesFound.get(i).getPrice() + ", #" + matchesFound.get(i).getId());
                }


            }

            if(option == 3) {  //ES: Option to modify a Product.
                Product modifiedProduct = new Product();
                System.out.println("Enter the item name you would like to modify");
                String userInput = str.nextLine().toLowerCase();
                Product productMatch = inventory.searchForProduct(userInput);

                if (productMatch == null) {  // If the product wasn't found in the search
                    System.out.println("Product was not found in the search");
                }

                //  If product is not null then we get the new info for the product and change it.
                else {
                    System.out.println("Enter the new info for " + productMatch.getName() + " separated by a comma\n" +
                            "Name, Price, Description, Stock,and Active Status(True or False)");
                    String[] line;
                    line = str.nextLine().split(",");
                    productMatch.setName(line[0]);
                    productMatch.setPrice(Double.parseDouble(line[1]));
                    productMatch.setDescription(line[2]);
                    productMatch.setStock(Integer.parseInt(line[3]));
                    productMatch.setActive(Boolean.parseBoolean(line[4]));
                }
            }
            if(option == 4) {
                DisplayInventory.display(inventory);
            }

            //DisplayInventory.display(inventory);
            System.out.println("\nMenu:\nEnter 1 to add a product\nEnter 2 to search for a product\nEnter 3 to modify an object\nEnter 4 to display the inventory\nEnter 0 to exit");
            option = inp.nextInt();
        }
        System.out.println("Operation complete. Closing Menu.");
    }
}
