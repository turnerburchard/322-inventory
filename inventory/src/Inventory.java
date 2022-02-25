import java.lang.reflect.Array;
import java.util.ArrayList; // import the ArrayList class

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public String toString(){
        return products.toString();
    }
}
