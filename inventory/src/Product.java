import java.util.UUID;

// Written by: Brady
// Reviewed by: Josh

public class Product { // data class for holding information concerning a single Product
    // all products in the inventory must have a unique ID, logically equivalent to a SKU/product #/UPC/serial #

    private String name;
    private double price;
    private String description;
    private boolean active;
    private int stock;
    private String id;

    Product() { // for creating a Product with a random ID, ID cannot be changed after creation
        name = "No Name Set";
        price = 0.00;
        description = "No Description Set";
        active = false;
        stock = 0;
        this.id = UUID.randomUUID().toString().substring(0,8);
    }

    Product(String inputID) { // for creating a Product with a specific ID, ID cannot be changed after creation
        this.id = inputID;
        name = "No Name Set";
        price = 0.00;
        description = "No Description Set";
        active = false;
        stock = 0;
    }

    //getters and setters for the all data attributes EXCEPT ID
    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }

    public void setPrice(double p) {
        price = p;
    }
    public double getPrice() {
        return price;
    }

    public void setDescription(String s) {
        description = s;
    }
    public String getDescription() {
        return description;
    }

    public void setStock(int p) {
        stock = p;
    }
    public int getStock() {
        return stock;
    }

    public void setActive(boolean p) {
        active = p;
    }
    public boolean getActive() {
        return active;
    }

    public String getId(){ return id; }
}