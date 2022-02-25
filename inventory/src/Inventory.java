import java.util.ArrayList;

public class Inventory {
    ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public String toString(){
        String out = "";

        for (Product p:products){
            out = String.join(out, p.toString(), "\n");
        }

        return out;
    }
}
