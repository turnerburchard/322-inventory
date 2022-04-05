public class Product {
    String name;
    double price;
    String description;
    Product() {
        name = "No Name Set";
        price = 0.00;
        description = "No Description Set";

    }
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

}
