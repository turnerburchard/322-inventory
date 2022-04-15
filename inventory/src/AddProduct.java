import java.util.Scanner;

public class AddProduct extends Modules {

    @Override
    public void moduleDriver() {
        userOptions();
        userInput();
        returnToMain();
    }

    @Override
    public void userOptions() {
        System.out.println("Enter Product Information separated by a comma:\n" +
                "Name, Price, Description, Stock,and Active Status(True or False)");
    }

    @Override
    public void userInput() {

        String[] productInfo;
        Scanner input = new Scanner(System.in);
        Product p = new Product();

        productInfo = input.nextLine().split(",");
        p.setName(productInfo[0]);
        p.setPrice(Double.parseDouble(productInfo[1]));
        p.setDescription(productInfo[2]);
        p.setStock(Integer.parseInt(productInfo[3]));
        p.setActive(Boolean.parseBoolean(productInfo[4]));

        Inventory inventory = Inventory.getInstance();
        inventory.addProduct(p);

    }

    @Override
    public void returnToMain() {
        UserInterface userInterface = new UserInterface();
        userInterface.menuMain();
    }
}
