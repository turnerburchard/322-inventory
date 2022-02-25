import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Window extends JFrame{
    public static JButton newProduct = new JButton("Create Product");

    private Inventory inventory = new Inventory();


    public Window(){
        //while (true){ //keep querying for new products until window is closed
            createFrame();
        //}

    }

    public void createFrame(){
        JFrame frame = new JFrame("Inventory");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTextArea products = new JTextArea(inventory.toString());
        products.setSize(400,400);

            products.setLineWrap(true);
            products.setEditable(false);
            products.setVisible(true);

            JScrollPane scroll = new JScrollPane (products);
                scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


        frame.add(newProduct, BorderLayout.NORTH);
        frame.add(scroll);


        Window.newProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField nameField = new JTextField();
                JTextField priceField = new JTextField();
                String message = "Please enter product name and price.";
                int result = JOptionPane.showOptionDialog(frame, new Object[] {message, nameField, priceField},"Login", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION){
                    try{
                        Product product = new Product(nameField.getText(), Double.parseDouble(priceField.getText()));
                        inventory.addProduct(product);
                        products.setText(inventory.toString());
                    }
                    catch (Exception error){
                        System.out.println("Invalid input");
                    }


                }

            }
        });

        frame.setVisible(true);
    }


}
