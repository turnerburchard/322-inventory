import java.util.UUID;

public class Product {
    String name;
    double price;
    String description;
    int id;
    static int counter = 0;

    /**
     * Product Class to store products with name, price, description, and ID
     * @param name Name of the product. Below 32 characters.
     * @param price Price of the product. Rounded to 2 decimals.
     */

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.description = "Default Description";
        this.id = counter++;
    }

    public void setDesc(String description){
        this.description = description;
    }

    public String toString() {
        return String.format("%s: $%.2f. \n%s\nID=%s\n\n", name, price, description,id);
    }


}
