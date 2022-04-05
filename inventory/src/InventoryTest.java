public class InventoryTest {
    public static void main(String[] args) {
        Product p = new Product();
        p.setName("Turner");
        p.setPrice(100000000);
        p.setDescription("Priceless, a bitch");
        System.out.println(p.getName() + " \nPrice: " + p.getPrice() + " \nDescription: " + p.getDescription());
    }
}
