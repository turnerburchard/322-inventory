import java.util.Scanner;

public class UserInterface {
    public static void menu() {
        System.out.println("Menu:\nEnter 1 to add a product\nEnter 2 to search for a product\nEnter 3 to modify an object\nEnter 0 to exit");
        Scanner inp = new Scanner(System.in);
        Scanner str = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int option = inp.nextInt();
        while(option != 0) {
            if(option == 1) {
                Product p = new Product();
                System.out.println("Enter Product Information separated by a comma:\n" +
                        "Name, Price, Description, Stock,and Active Status(True or False)");
                String[] line;
                line = str.nextLine().split(",");
                p.setName(line[0]);
                p.setPrice(Double.parseDouble(line[1]));
                p.setDescription(line[2]);
                p.setStock(Integer.parseInt(line[3]));
                p.setActive(Boolean.parseBoolean(line[4]));
                inventory.addProduct(p);
            }
            DisplayInventory.display(inventory);
            System.out.println("Menu:\nEnter 1 to add a product\nEnter 2 to search for a product\nEnter 3 to modify an object\nEnter 0 to exit");
            option = inp.nextInt();
        }
        System.out.println("Operation complete. Closing Menu.");
    }
}
