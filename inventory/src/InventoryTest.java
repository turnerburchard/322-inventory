import java.io.File;
import java.io.FileNotFoundException;

public class InventoryTest {
    public static void main(String[] args) throws FileNotFoundException {
        Product p = new Product();
        p.setName("Turner's Fantastic Stir Fry and Cherry Pie");
        p.setPrice(19.99);
        p.setDescription("This Stir Fry evokes memories of the salty breeze off the ocean, and a warm summer day");
        System.out.println(p.getName() + " \nPrice: " + p.getPrice() + " \nDescription: " + p.getDescription());

        File data = new File("C:\\Users\\brady\\IdeaProjects\\322-inventory\\inventory\\src\\Data(1).csv");
        Inventory inventory = new Inventory(data);
        inventory.addProduct(p);
        DisplayInventory.display(inventory);
    }
}