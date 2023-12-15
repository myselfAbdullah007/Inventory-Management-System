package PL;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CustomerProductGUI extends JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public CustomerProductGUI() {
        // Set up the main frame
        setTitle("Product Catalog");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create table data and column names
        Vector<Vector<String>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("Product ID");
        columnNames.add("Name");
        columnNames.add("Description");
        columnNames.add("Price");

        // Sample data
        Vector<String> row1 = new Vector<>();
        row1.add("P001");
        row1.add("Laptop");
        row1.add("High-performance laptop");
        row1.add("$1000.00");

        Vector<String> row2 = new Vector<>();
        row2.add("P002");
        row2.add("Smartphone");
        row2.add("Latest smartphone model");
        row2.add("$500.00");

        data.add(row1);
        data.add(row2);

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create JTable with the model
        JTable productTable = new JTable(tableModel);

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

            // You can implement the logic to add the selected product to the cart
            JOptionPane.showMessageDialog(this, "Added to Cart:\n" +
                    "Product ID: " + productId + "\n" +
                    "Name: " + name + "\n" +
                    "Description: " + description + "\n" +
                    "Price: " + price);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a product to add to the cart.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerProductGUI().setVisible(true);
            }
        });
    }
}

