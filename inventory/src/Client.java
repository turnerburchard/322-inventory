public class Client {
    public static void main(String[] args) {
        Product test = new Product("Test", 10.12589);
        test.addDesc("A product to display future possibilities.");
        test.addID("000001");
        System.out.println(test);
    }
}
