import java.util.ArrayList;

public class DisplayInventory {
    public void display(Inventory inv) {
        ArrayList<Product> inventory = inv.inventory;
        for(Product p: inventory) {
            System.out.printf("%20s %8s %s", p.getName(), p.getPrice(), p.getDescription());
        }
    }
}