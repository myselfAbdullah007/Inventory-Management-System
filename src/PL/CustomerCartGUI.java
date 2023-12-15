package PL;

import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class CustomerCartGUI extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public CustomerCartGUI() {
        // Set up the main frame
        setTitle("Customer Cart");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and set font for the label
        Font labelFont = new Font("Arial", Font.BOLD, 25);

        // Create label
        JLabel titleLabel = new JLabel("Shopping Cart");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(labelFont);

        // Create table data and column names
        Vector<Vector<String>> data = new Vector<>();
        Vector<String> columnNames = new Vector<>();
        columnNames.add("OrderID");
        columnNames.add("ProductID");
        columnNames.add("Quantity");
        columnNames.add("OrderDate");
        columnNames.add("Cost");

        // Sample data
        Vector<String> row1 = new Vector<>();
        row1.add("1");
        row1.add("P001");
        row1.add("2");
        row1.add("2023-01-01");
        row1.add("$100.00");

        Vector<String> row2 = new Vector<>();
        row2.add("2");
        row2.add("P002");
        row2.add("1");
        row2.add("2023-01-02");
        row2.add("$50.00");

        data.add(row1);
        data.add(row2);

        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create JTable with the model
        JTable cartTable = new JTable(tableModel);

        // Create buttons
        JButton confirmButton = new JButton("Confirm Order");
        JButton deleteButton = new JButton("Delete Order");

        // Set layout manager
        setLayout(new BorderLayout());

        // Add components to the frame
        add(titleLabel, BorderLayout.NORTH);
        add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(confirmButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners
        confirmButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Confirm Order button action
                handleConfirmOrderAction();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle Delete Order button action
                handleDeleteOrderAction();
            }
        });
    }

    private void handleConfirmOrderAction() {
        // You can implement the logic for the Confirm Order button action here
        JOptionPane.showMessageDialog(this, "Order Confirmed");
    }

    private void handleDeleteOrderAction() {
        // You can implement the logic for the Delete Order button action here
        JOptionPane.showMessageDialog(this, "Order Deleted");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerCartGUI().setVisible(true);
            }
        });
    }
}

