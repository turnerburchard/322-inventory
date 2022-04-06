import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
//Brady Ash 4/4
public class Inventory {
    ArrayList<Product> inventory;

    Inventory(){
        inventory = new ArrayList<>();
    }

    //for csv input
    Inventory(File file) throws FileNotFoundException {
        inventory = new ArrayList<>();
        Scanner scan = new Scanner(file);
        while(scan.hasNextLine()) {
            Product p = new Product();
            String[] line = scan.nextLine().split(",");
            p.setName(line[0]);
            p.setPrice(Double.parseDouble(line[1]));
            p.setDescription(line[2]);
            p.setStock(Integer.parseInt(line[3]));
            p.setActive(Boolean.parseBoolean(line[4]));
            inventory.add(p);
        }
        scan.close();
    }
    public void addProduct(Product p) {
        inventory.add(p);
    }
}