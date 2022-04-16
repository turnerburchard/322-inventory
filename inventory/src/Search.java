import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Search extends Modules {

    public void moduleDriver() throws IOException {
        userOptions();
        userInput();
        try {
            returnToMain();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void userOptions() {
        System.out.println("Enter the first few character of a product's name to get a list of matching products.");
    }

    public void userInput() throws IOException {
        Scanner str = new Scanner(System.in);
        String userInput = str.nextLine();
        userInput = userInput.toLowerCase();

        Inventory tempInventory = Inventory.getInstance();
        ArrayList<Product> inventory = tempInventory.getInventory();

        ArrayList<Product> matchesFound = new ArrayList<>();
        for(Product eachProduct : inventory) {  //  Check each item in the inventory to see if it contains matching letters with user input
            String tempProduct = eachProduct.getName();
            tempProduct = tempProduct.toLowerCase();
            if(tempProduct.contains(userInput)) {
                matchesFound.add(eachProduct);
            }
        }

        //  Loop through and print each product that was found from the searchInventory method
        System.out.println("Size:" + matchesFound.size());
        for (int i = 0; i < matchesFound.size(); i++) {
            System.out.println(i + ":" + matchesFound.get(i).getName() + ", $" + matchesFound.get(i).getPrice() + ", #" + matchesFound.get(i).getId());
        }
    }

}
