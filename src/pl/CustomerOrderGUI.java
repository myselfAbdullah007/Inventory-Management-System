package pl;

import com.formdev.flatlaf.FlatDarkLaf;

import dal.CartDAO;
import dal.DatabaseConnection;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class CustomerOrderGUI extends JFrame {

    static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    private JTable orderTable;
    private CartDAO orders;
    private String customerid;

    public CustomerOrderGUI(String customerid) {
    	orders=new CartDAO();
    	this.customerid=customerid;
        // Set up the main frame
        setTitle("Customer Order Details");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and set font for the label
        Font labelFont = new Font("Arial", Font.BOLD, 25);

        // Create label
        JLabel titleLabel = new JLabel("Orders Status");
        titleLabel.setFont(labelFont);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create table data and column names
        Vector<Vector<String>> allData = orders.getAllOrderData(customerid);
        Vector<String> columnNames = new Vector<>();
        columnNames.add("OrderID");
        columnNames.add("Product Name");
        columnNames.add("OrderType");
        columnNames.add("OrderStatus");
        columnNames.add("OrderCost");
        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(allData, columnNames);

        // Create JTable with the model
        orderTable = new JTable(tableModel);

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
                new CustomerOrderGUI("1001").setVisible(true);
            }
        });
    }
}
