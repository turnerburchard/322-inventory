public class Product {
    String name;
    double price;
    String description;
    String id;

    /**
     * Product Class to store products with name, price, description, and ID
     * @param name Name of the product. Below 32 characters.
     * @param price Price of the product. Rounded to 2 decimals.
     */

    public Product(String name, double price){
        this.name = name;
        this.price = price;
        this.description = "";
        this.id = "000000";
    }

    public void addDesc(String description){
        this.description = description;
    }

    public void addID(String id){
        this.id = id;
    }

    public String toString() {
        return String.format("%s: $%.2f. %s", name, price, description);
    }


}
