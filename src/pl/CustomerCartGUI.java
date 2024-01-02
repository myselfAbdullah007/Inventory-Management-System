package pl;

import com.formdev.flatlaf.FlatDarkLaf;

import dal.CartDAO;

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
	JTable cartTable;
	String customerId;

    public CustomerCartGUI(String customerId) {
    	this.customerId=customerId;
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
        Vector<Vector<String>> data = CartDAO.getCartData(customerId);

        Vector<String> columnNames = new Vector<>();
        columnNames.add("ProductID");
        columnNames.add("Product Name");
        columnNames.add("Cost");


        // Create table model
        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames);

        // Create JTable with the model
        cartTable = new JTable(tableModel);

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
        int selectedRow = cartTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to confirm the order.");
            return;
        }

        String productId = cartTable.getValueAt(selectedRow, 0).toString(); 
        String orderType = "Online"; 
        String orderStatus = "Pending"; 
        
        // Ask the user for the quantity
        String quantityStr = JOptionPane.showInputDialog(this, "Enter quantity for the selected product:");
        
        if (quantityStr == null || quantityStr.trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Quantity cannot be empty. Order not confirmed.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
            if (quantity <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid positive integer for quantity. Order not confirmed.");
            return;
        }

        float orderCost = Float.parseFloat(cartTable.getValueAt(selectedRow, 2).toString().replace("$", ""))*quantity; // Assuming Cost is in the fifth column

        // Call the DAO method to confirm the order and update orderdetails
        CartDAO.confirmOrder(productId, customerId, orderType, orderStatus, quantity, orderCost);

        removeSelectedRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Order Confirmed");
    }


    private void handleDeleteOrderAction() {
        int selectedRow = cartTable.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a product to delete.");
            return;
        }

        // Get data from the selected row
        String productId = cartTable.getValueAt(selectedRow, 0).toString(); // Assuming ProductID is in the second column

        // Call the DAO method to delete the product from the cart
        CartDAO.deleteProductFromCart(productId, customerId);

        // Remove the deleted product from the cart table
        removeSelectedRow(selectedRow);

        JOptionPane.showMessageDialog(this, "Product Deleted");
    }

    private void removeSelectedRow(int selectedRow) {
        DefaultTableModel model = (DefaultTableModel) cartTable.getModel();
        model.removeRow(selectedRow);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerCartGUI("1001").setVisible(true);
            }
        });
    }
}

