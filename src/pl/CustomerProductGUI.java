package pl;

import com.formdev.flatlaf.FlatDarkLaf;

import DTO.Product;
import dal.ProductDAO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class CustomerProductGUI extends JFrame {
	
    private ProductDAO productDAO;
    private String customerName;


    static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public CustomerProductGUI(String customerName) {
    	this.customerName=customerName;
    	
    	
    	 // Initialize the ProductDAO
        this.productDAO = new ProductDAO();

        // Fetch products from the database
        List<Product> products = productDAO.getAllProducts();

        // Create table model with fetched data
        DefaultTableModel tableModel = createTableModel(products);

        // Create JTable with the model
        JTable productTable = new JTable(tableModel);
        
        
        // Set up the main frame
        setTitle("Product Catalog");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create table data and column names
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Product ID");
        columnNames.add("Name");
        columnNames.add("Description");
        columnNames.add("Price");

        // Create button to add product to cart
        JButton addToCartButton = new JButton("Add to Cart");

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(addToCartButton);
        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listener for the "Add to Cart" button
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Add to Cart button action
                handleAddToCartAction(productTable);
            }
        });
    }
    private void handleAddToCartAction(JTable productTable) {
        int selectedRow = productTable.getSelectedRow();

        if (selectedRow != -1) {
            // Get selected product information
            String productId = (String) productTable.getValueAt(selectedRow, 0);
            String name = (String) productTable.getValueAt(selectedRow, 1);
            String description = (String) productTable.getValueAt(selectedRow, 2);
            String price = (String) productTable.getValueAt(selectedRow, 3);

            // Add the selected product to the cart in the database
            productDAO.addToCart(productId, customerName);

            JOptionPane.showMessageDialog(this, "Added to Cart:\n" +
                    "Product ID: " + productId + "\n" +
                    "Name: " + name + "\n" +
                    "Description: " + description + "\n" +
                    "Price: " + price);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.");
        }
    }
    private DefaultTableModel createTableModel(List<Product> products) {
        Vector<Vector<String>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Product ID");
        columnNames.add("Name");
        columnNames.add("Description");
        columnNames.add("Price");

        for (Product product : products) {
            Vector<String> row = new Vector<>();
            row.add(product.getProductId());
            row.add(product.getName());
            row.add(product.getDescription());
            row.add(product.getPrice());
            data.add(row);
        }

        return new DefaultTableModel(data, columnNames);
    }
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new CustomerProductGUI(customerName).setVisible(true);
//            }
//        });
//    }
}

