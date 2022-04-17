import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

// Written by: Turner
// Reviewed by: Jeremy

public class Search extends Modules { // system function, allows user to display Products by specified parameters

    public void moduleDriver() throws IOException { // drives module
        moduleMenu();

        try {
            returnToMain();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void moduleMenu() throws IOException { // displays the module's main menu, handles input
        System.out.println("====| Search By: ");
        System.out.println("1 -> ID " +
                "\n2 -> Name" +
                "\n3 -> Description" +
                "\n4 -> Stock" +
                "\n5 -> Status" +
                "\n0 -> Exit to Main Menu");

        System.out.println(">>>> Enter Menu #: ");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        if (userChoice.equals("0")) { // brings user straight to main menu
            returnToMain();
        }

        System.out.println(">>>> Enter Search Parameter: ");
        Scanner scanner1 = new Scanner(System.in);
        String searchParam = scanner1.nextLine();
        searchParam = searchParam.toLowerCase();

        searchFunction(userChoice, searchParam);
    }

    private void searchFunction(String userChoice, String searchParam) throws IOException { // performs functionality of module, mostly for code readability
        ArrayList<Product> inventory = Inventory.getInstance().returnInventorySec(); // gets copy of current inventory

        ArrayList<Product> searchResults = new ArrayList<>(); // for storing results of a search
        String searchType = null; // for the type of search that was conducted, used for calling displaySearchResults()

        switch (userChoice) {
            case "1" -> {
                searchType = "ID";

                for (Product eachProduct : inventory) {  //  Check each Product ID in the inventory to see if it contains matching substring
                    String tempProduct = eachProduct.getId();

                    tempProduct = tempProduct.toLowerCase();

                    if (tempProduct.contains(searchParam)) {
                        searchResults.add(eachProduct);
                    }
                }
            }

            case "2" ->  {
                searchType = "Name";
            }
            case "3" -> searchType = "Description";
            case "4" -> searchType = "Stock";
            case "5" -> searchType = "Status";
            default -> {
                System.out.println("====| Input Not Understood -> Try Again"); // user input error-catcher
                moduleMenu();
            }
        }

        displaySearchResults(searchResults, searchType);

        moduleMenu();
    }

    private void displaySearchResults(ArrayList<Product> results, String searchType) throws IOException {
        int lineCounter = 1;

        if (results.isEmpty()) {
            System.out.println("====| No results to display ");

            moduleMenu();
        }

        System.out.println("====| Search by " + searchType + " Results: ");
        System.out.printf("%-8s %-15s %-30s %-30s %8s %8s %-15s\n", "Line", "ID", "Product Name", "Product Description", "Price", "Stock", "Status");

        //runs through the inventory and prints out product information
        for (Product p : results) {
            String tempName;
            String tempDesc;
            String tempActive;
            String tempStock;
            //If name/desc is longer than 30 chars, will cut them off at 27 and add 3 dots.
            if (p.getName().length() > 30) {
                tempName = p.getName().substring(0, 26);
                tempName = tempName + "...";
            } else {
                tempName = p.getName();
            }
            if (p.getDescription().length() > 30) {
                tempDesc = p.getDescription().substring(0, 26);
                tempDesc = tempDesc + "...";
            } else {
                tempDesc = p.getDescription();
            }
            if (p.getActive()) {
                tempActive = "Active";
            } else {
                tempActive = "Inactive";
            }
            tempStock = Integer.toString(p.getStock());
            //Print out inventory list.

            System.out.printf("%-8s %-15s %-30s %-30s %8s %8s %-15s  \n", lineCounter, p.getId(), tempName, tempDesc, p.getPrice(), tempStock, tempActive);

            lineCounter++;
        }
    }
}

// System.out.println("Enter the first few character of a product's name to get a list of matching products.");
//    Scanner str = new Scanner(System.in);
//    String userInput = str.nextLine();
//        userInput = userInput.toLowerCase();
//
//                Inventory tempInventory = Inventory.getInstance();
//                ArrayList<Product> inventory = tempInventory.returnInventorySec();
//
//        ArrayList<Product> matchesFound = new ArrayList<>();
//        for(Product eachProduct : inventory) {  //  Check each item in the inventory to see if it contains matching letters with user input
//        String tempProduct = eachProduct.getName();
//        tempProduct = tempProduct.toLowerCase();
//        if(tempProduct.contains(userInput)) {
//        matchesFound.add(eachProduct);
//        }
//        }
//
//        //  Loops through and prints each product that was found from the searchInventory method
//        System.out.println("Size:" + matchesFound.size());
//        for (int i = 0; i < matchesFound.size(); i++) {
//        System.out.println(i + ":" + matchesFound.get(i).getName() + ", $" + matchesFound.get(i).getPrice() + ", #" + matchesFound.get(i).getId());
//        }