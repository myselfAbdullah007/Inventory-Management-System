package pl;

import dal.CustomerAuthenticationDAO;
import log.Log;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {
	static {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }
    private JTextField name;
    private JPasswordField passwordField;

    public Login() {
        setTitle("Inventory Management System");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        inputPanel.setLayout(null);

        JLabel headingLabel = new JLabel("Welcome to Shopping APP");
        headingLabel.setBounds(65, 43, 320, 91);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 20));
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        inputPanel.add(headingLabel);

        JLabel lname = new JLabel("Name: ");
        lname.setBounds(98, 129, 49, 75);
        lname.setFont(UIManager.getFont("Button.font"));
        inputPanel.add(lname);

        name = new JTextField(20);
        name.setBounds(157, 145, 191, 38);
        inputPanel.add(name);

        JLabel lpassword = new JLabel("Password: ");
        lpassword.setBounds(98, 190, 75, 51);
        lpassword.setFont(UIManager.getFont("Button.font"));
        inputPanel.add(lpassword);

        passwordField = new JPasswordField(20);
        passwordField.setBounds(157, 194, 191, 38);
        inputPanel.add(passwordField);

        JButton button = new JButton("Login");
        button.setBounds(267, 252, 81, 38);
        button.setFont(UIManager.getFont("Button.font"));
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleLogin();
            }
        });
        inputPanel.add(button);

        getContentPane().add(mainPanel);
    }

    private void handleLogin() {
        String userName = name.getText();
        String password = new String(passwordField.getPassword());

        // Authenticate user using DAO
        CustomerAuthenticationDAO authDAO = new CustomerAuthenticationDAO();
        boolean isAuthenticated = authDAO.authenticateCustomer(userName, password);

        if (isAuthenticated) {
            // If authenticated, open the CustomerProductGUI
            SwingUtilities.invokeLater(() -> {
                CustomerGUI customerProductGUI = new CustomerGUI(userName);
                customerProductGUI.setVisible(true);
            });

            // Close the current login window
            dispose();
        } else {
            // Display an error message for invalid credentials
            JOptionPane.showMessageDialog(this, "Invalid credentials. Please try again.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            Log.LOGGER.error("Invalid Customer Credentials");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Login login = new Login();
            login.setVisible(true);
        });
    }
}
