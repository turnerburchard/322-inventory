import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Inventory {
    ArrayList<Product> inventory;
    Inventory(){
        inventory = new ArrayList<Product>();
    }
    //for csv input
    Inventory(File file) throws FileNotFoundException {
        inventory = new ArrayList<Product>();
        Scanner scan = new Scanner(file);
        while(scan.hasNext()) {
            Product p = new Product();
            String line[] = scan.nextLine().split(", ");
            p.setName(line[0]);
            p.setPrice(Double.parseDouble(line[1]));
            p.setDescription(line[2]);
            inventory.add(p);
        }

    }
}




















