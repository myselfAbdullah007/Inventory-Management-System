package pl;

import javax.swing.*;
import com.formdev.flatlaf.FlatDarkLaf;

import dal.CustomerAuthenticationDAO;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField customerIDField;
    private JPasswordField passwordField;
    private JLabel resultLabel;

    public AdminLogin() {
        // Set up the frame
        setTitle("Admin Authentication");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create components
        JLabel titleLabel = new JLabel("Admin Authentication");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        JLabel customerIDLabel = new JLabel("Admin ID:");
        JLabel passwordLabel = new JLabel("Password:");
        customerIDField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton authenticateButton = new JButton("Authenticate");
        resultLabel = new JLabel("");

        // Set layout manager to center components
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.CENTER;

        // Add title label
        add(titleLabel, gbc);

        // Move to the next row for other components
        gbc.gridy++;

        // Add components to the frame
        gbc.anchor = GridBagConstraints.EAST;
        add(customerIDLabel, gbc);
        gbc.gridy++;
        add(passwordLabel, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx++;
        gbc.gridy = 1; // Start the components from the second row
        add(customerIDField, gbc);
        gbc.gridy++;
        add(passwordField, gbc);
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.CENTER;
        add(authenticateButton, gbc);
        gbc.gridy++;
        add(resultLabel, gbc);

        // Add action listener for the authenticate button
        authenticateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                authenticateCustomer();
            }
        });

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    private void authenticateCustomer() {
        // Get Admin credentials from the text fields
        String customerID;
        try {
            customerID = customerIDField.getText();
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid Admin ID");
            return;
        }

        String password = new String(passwordField.getPassword());

        // Authenticate Admin
        boolean isAuthenticated = aunthenticator(customerID, password);
        // Display result
        if (isAuthenticated) {
            resultLabel.setText("Admin is authenticated.");
            new AdminGUI().setVisible(true);
            
        } else {
            resultLabel.setText("Invalid credentials. Admin not registered.");
        }
    }
    Boolean aunthenticator(String ID , String pass)
    {
    	Boolean x= false;
        if (ID .equals("admin") && pass.equals("admin"))
        {
        	 x= true;
        }
    	return x;
    }
}
