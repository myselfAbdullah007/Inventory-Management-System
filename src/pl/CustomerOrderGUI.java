package pl;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Vector;

public class CustomerOrderGUI extends JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public CustomerOrderGUI() {
        // Set up the main frame
        setTitle("Customer Order History");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and set font for the label
        Font labelFont = new Font("Arial", Font.BOLD, 25);
        

        // Create label
        JLabel titleLabel = new JLabel("Orders Status");
        titleLabel.setFont(labelFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create table data and column names
        Vector<Vector<String>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("OrderID");
        columnNames.add("Product Type");

        // Sample data
        Vector<String> row1 = new Vector<>();
        row1.add("1");
        row1.add("Electronics");

        Vector<String> row2 = new Vector<>();
        row2.add("2");
        row2.add("Clothing");

        data.add(row1);
        data.add(row2);

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create JTable with the model
        JTable orderTable = new JTable(tableModel);

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(orderTable), BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerOrderGUI().setVisible(true);
            }
        });
    }
}
