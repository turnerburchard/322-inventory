import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.GridLayout;


public class Window extends JFrame{
    private static JButton newProduct = new JButton("Create Product");
    private static JButton removeProduct = new JButton("Remove Product");

    private Inventory inventory = new Inventory();

    public Window(){
        //while (true){ //keep querying for new products until window is closed
            createFrame();
        //}
    }

    public void createFrame(){
        JFrame frame = new JFrame("Inventory");
        frame.setBackground(Color.DARK_GRAY);
        frame.setLayout(new GridLayout(3,3));
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

        //Button styling
        Border line = new LineBorder(Color.BLACK);
        Border margin = new EmptyBorder(5, 15, 5, 15);
        Border compound = new CompoundBorder(line, margin);
        newProduct.setForeground(Color.green);
        newProduct.setBackground(Color.gray);

        newProduct.setBorder(compound);

        removeProduct.setForeground(Color.red);
        removeProduct.setBackground(Color.gray);
        removeProduct.setBorder(compound);

        frame.add(newProduct, BorderLayout.NORTH);
        frame.add(removeProduct, BorderLayout.NORTH);
        frame.add(scroll);


        Window.newProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField nameField = new JTextField();
                JTextField priceField = new JTextField();
                JTextField descField = new JTextField();
                String message = "Please enter product name, price, and description.";
                String message2 = "Name:";
                String message3 = "Price:";
                String message4 = "Description:";
                int result = JOptionPane.showOptionDialog(frame, new Object[] {message, message2, nameField, message3, priceField, message4, descField},
                        "Create a New Product", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION){
                    String name = nameField.getText();
                    String desc = descField.getText();
                    try{
                        Product product = new Product(name, Double.parseDouble(priceField.getText()));
                        if (name.length() < 3 || desc.length() < 3 || name.length() > 50 || desc.length() > 50){
                            throwError("Name and description must be 3-50 characters in length.");
                        }
                        else if(inventory.contains(name)) { //  Checks if name has already been added to inventory.
                            throwError("This item name is already in the system.");
                        }
                        else{
                            product.setDesc(desc);
                            inventory.addProduct(product);
                            products.setText(inventory.toString());

                        }
                    }
                    catch (NumberFormatException error){
                        throwError("Price must be a valid number");
                    }
                    catch (Exception error){
                        throwError("Invalid Input");
                    }
                }
            }
        });

        Window.removeProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idField = new JTextField();
                String message = "Please enter ID of product to be removed: ";

                int result = JOptionPane.showOptionDialog(frame, new Object[] {message, idField}, "Remove a Product",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);

                if (result == JOptionPane.OK_OPTION){
                    try{
                        inventory.removeProduct((idField.getText()));
                        products.setText(inventory.toString());
                    }

                    catch (Exception error){
                        throwError("Invalid Input");
                    }

                }
            }


        });

        frame.setVisible(true);
    }


    private void throwError(String error){
        JOptionPane.showMessageDialog(null, error,"Error", JOptionPane.ERROR_MESSAGE);
    }
}
