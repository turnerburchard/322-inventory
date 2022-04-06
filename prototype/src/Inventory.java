import java.util.ArrayList;

public class Inventory {
    static ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product p){
        products.add(p);
    }

    public void removeProduct(String id){
        products.removeIf(e -> e.getID().equals(id));
    }

    /***
     * Checks if the new product's name is already contained in the list of products.
     * Returns FALSE if the product name does not exist
     * Returns TRUE if the product name already exist
     ***/
    public boolean contains(String newProduct) {

        for (Product product : products) {
            String productName = product.getName();
            if (productName.equals(newProduct)) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String out = "";
        for (Product p:products){
            out = String.join(out, p.toString(), "\n");
        }
        return out;
    }
}
