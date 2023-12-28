package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ShoppingCart {
    private JFrame frame;
    private JPanel panel;
    private JButton addButton;
    private JTextField itemField;
    private JTextField priceField;
    private JLabel itemLabel;
    private JLabel priceLabel;
    private DefaultListModel<String> listModel;
    private JList<String> itemList;


    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        Product product1 = new Product("Laptop", 1500.0);
        Product product2 = new Product("Smartphone", 800.0);

        cart.addItem(product1);
        cart.addItem(product2);

        cart.printStruct(); // Print the shopping cart struct
    }

private final List<Product> products;
    public ShoppingCart() {
    products = new ArrayList<>(); // Initialize the products list
    initialize();
    }
        public void addItem(Product product) {
        products.add(product);
    }

    public void removeItem(Product product) {
        products.remove(product);
    }


    private void initialize() {
        frame = new JFrame("Shopping Cart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);

        itemLabel = new JLabel("Item Name:");
        itemLabel.setBounds(10, 20, 100, 25);
        panel.add(itemLabel);

        itemField = new JTextField();
        itemField.setBounds(120, 20, 250, 25);
        panel.add(itemField);

        priceLabel = new JLabel("Item Price:");
        priceLabel.setBounds(10, 60, 100, 25);
        panel.add(priceLabel);

        priceField = new JTextField();
        priceField.setBounds(120, 60, 250, 25);
        panel.add(priceField);

        addButton = new JButton("Add to Cart");
        addButton.setBounds(120, 100, 250, 25);
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });
        panel.add(addButton);

        listModel = new DefaultListModel<>();
        itemList = new JList<>(listModel);
        itemList.setBounds(10, 140, 370, 120);
        panel.add(new JScrollPane(itemList));

        frame.getContentPane().add(panel);
    }

    private void addItem() {
        String itemName = itemField.getText();
        String itemPrice = priceField.getText();

        if (!itemName.isEmpty() && !itemPrice.isEmpty()) {
            Product product = new Product(itemName, Double.parseDouble(itemPrice));
            products.add(product);
            listModel.addElement(product.toString());
            itemField.setText("");
            priceField.setText("");
        } else {
            JOptionPane.showMessageDialog(frame, "Please enter a valid item name and price.");
        }
    }
    

 public void printStruct() {
    String title = "Shopping Cart";
    int rows = products.size() + 1;
    int columns = 3;
    JTable table = new JTable(new DefaultTableModel(rows, columns));
    JScrollPane scrollPane = new JScrollPane(table);
    table.setValueAt(title, 0, 0);
    table.setValueAt("Product Name", 0, 1);
    table.setValueAt("Product Price", 0, 2);
    int i = 1;
    for (Product product : products) {
        table.setValueAt(product.getName(), i, 1);
        table.setValueAt(product.getPrice(), i, 2);
        i++;
    }
    JOptionPane.showMessageDialog(null, scrollPane, "Shopping Cart", JOptionPane.INFORMATION_MESSAGE);
}
}

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " - " + price;
    }
        public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}