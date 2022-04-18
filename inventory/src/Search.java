import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

// Written by: Turner
// Reviewed by: Jeremy

public class Search extends Modules { // system function, allows user to display Products by specified parameters

    public void moduleDriver() throws IOException { // drives module
        moduleMenu();

        try { // the java IDE gods said put this in so...
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
                "\n4 -> Status (y or n)" +
                "\n0 -> Exit to Main Menu");

        System.out.println(">>>> Enter Menu #: ");
        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        if (userChoice.equals("0")) { // brings user straight to main menu
            returnToMain();
        }
        else if(!userChoice.equals("1") && !userChoice.equals("2") && !userChoice.equals("3") && !userChoice.equals("4")){
            // user input error-catcher
            System.out.println("====| Input Not Understood -> Try Again");

            moduleMenu();
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

        switch (userChoice) { // for appropriate handling of userChoice
            case "1" -> { // search by ID
                searchType = "ID";

                for (Product eachProduct : inventory) {  //  Check each Product ID in the inventory to see if it contains matching substring
                    String tempProduct = eachProduct.getId();

                    tempProduct = tempProduct.toLowerCase();

                    if (tempProduct.contains(searchParam)) {
                        searchResults.add(eachProduct);
                    }
                }
            }

            case "2" ->  { // search by name
                searchType = "Name";

                for (Product eachProduct : inventory) {  //  Check each Product ID in the inventory to see if it contains matching substring
                    String tempProduct = eachProduct.getName();

                    tempProduct = tempProduct.toLowerCase();

                    if (tempProduct.contains(searchParam)) {
                        searchResults.add(eachProduct);
                    }
                }
            }

            case "3" ->  { // search by description
                searchType = "Description";

                for (Product eachProduct : inventory) {  //  Check each Product ID in the inventory to see if it contains matching substring
                    String tempProduct = eachProduct.getDescription();

                    tempProduct = tempProduct.toLowerCase();

                    if (tempProduct.contains(searchParam)) {
                        searchResults.add(eachProduct);
                    }
                }
            }

            case "4" -> { // search by status
                // user input for searchParam has to be "y" or "n"

                searchType = "Status";

                for (Product eachProduct : inventory) {  //  Check each Product ID in the inventory to see if it contains matching substring
                    boolean tempProduct = eachProduct.getActive();

                    if (searchParam.equals("y")) { // if Product is active
                        if (tempProduct) {
                            searchResults.add(eachProduct);
                        }
                    } else if (searchParam.equals("n")) { // if Product is inactive
                        if (!tempProduct) {
                            searchResults.add(eachProduct);
                        }
                    }
                    else { // user input error-catcher
                        System.out.println("====| Input Not Understood -> Try Again");
                        moduleMenu();
                    }
                }
            }

            default -> { // user input error-catcher
                System.out.println("====| Input Not Understood -> Try Again"); // user input error-catcher
                moduleMenu();
            }
        }

        displaySearchResults(searchResults, searchType); // displays results of the search type chosen by user

        moduleMenu();
    }

    private void displaySearchResults(ArrayList<Product> results, String searchType) throws IOException { // displays results of various search functions
        // takes an ArrayList<Product> and searchType, for display/printing purposes

        int lineCounter = 1; // keeps track of the line number of a Product being printed

        if (results.isEmpty()) { // if there are no results from a search, returns to module menu
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