public class Product {
    String name;
    double price;
    String description;
    String id;

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
