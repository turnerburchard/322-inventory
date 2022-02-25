import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame{
    public static JTextArea nameIn = new JTextArea("Enter Name - ");
    public static JTextArea priceIn = new JTextArea("Enter Price - ");
    public static JButton newProduct = new JButton("Create Product");//creating instance of JButton

    private Inventory inventory = new Inventory();


    private String name;
    private String price;

    public Window(){
        //while (true){ //keep querying for new products until window is closed
            createFrame();
        //}

    }

    public void createFrame(){
        JFrame frame = new JFrame("Inventory");
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(newProduct, BorderLayout.NORTH);
        frame.add(nameIn, BorderLayout.EAST);
        frame.add(priceIn, BorderLayout.WEST);

        Window.newProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                name = nameIn.getText();
                price = priceIn.getText();

                nameIn.setText("");
                priceIn.setText("");

                Product product = new Product(name,  Double.parseDouble(price));
                inventory.addProduct(product);
                System.out.println(inventory);

            }
        });


        //Display the window.

        frame.setVisible(true);
    }


}
