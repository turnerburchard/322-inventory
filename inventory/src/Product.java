//Brady Ash 4/4
//Class that creates an object to hold a product's important information.
public class Product {
    private String name;
    private double price;
    private String description;
    private Boolean active;
    private int stock;
    private final String id;

    //generic class
    Product() {
        name = "No Name Set";
        price = 0.00;
        description = "No Description Set";
        active = false;
        stock = 0;
        id = Double.toString(Math.random()).substring(4,9);

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

    public String getId(){ return id; }
}