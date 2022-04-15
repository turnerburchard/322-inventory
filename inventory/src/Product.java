import java.util.UUID;

public class Product {
    private String name;
    private double price;
    private String description;
    private boolean active;
    private int stock;
    private String id;

    //generic class
    Product() {
        name = "No Name Set";
        price = 0.00;
        description = "No Description Set";
        active = false;
        stock = 0;
        this.id = UUID.randomUUID().toString().substring(0,8);
    }

    //getters and setters for the important information.
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

    public void setId(String i) { id = i; }
    public String getId(){ return id; }
}