package pl;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerGUI extends JFrame {

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

    public CustomerGUI() {
        // Set up the main frame
        setTitle("Customer Module");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel titleLabel = new JLabel("Happy Shopping!");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        JButton orderButton = new JButton("ORDER");
        JButton cartButton = new JButton("CART");
        JButton viewProductsButton = new JButton("View Products");
        JButton logoutButton = new JButton("LOGOUT");

        // Set preferred button size
        Dimension buttonSize = new Dimension(150, 50);
        orderButton.setPreferredSize(buttonSize);
        cartButton.setPreferredSize(buttonSize);
        viewProductsButton.setPreferredSize(buttonSize);
        logoutButton.setPreferredSize(buttonSize);

        // Set layout manager
        setLayout(new GridBagLayout());

        // Create constraints for centering
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2; // Span the entire width for the title
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add components to the frame with constraints
        add(titleLabel, gbc);

        // Create constraints for buttons
        gbc.gridwidth = 1; // Reset gridwidth to 1 for buttons

        gbc.gridy = 1;
        add(orderButton, gbc);

        gbc.gridx = 1;
        add(cartButton, gbc);

        gbc.gridy = 2;
        gbc.gridx = 0;
        add(viewProductsButton, gbc);

        gbc.gridx = 1;
        add(logoutButton, gbc);

        // Add action listeners
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle ORDER button action
                handleOrderAction();
            }
        });

        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle CART button action
                handleCartAction();
            }
        });

        viewProductsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle View Products button action
                handleViewProductsAction();
            }
        });

        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle LOGOUT button action
                handleLogoutAction();
            }
        });
    }

    private void handleOrderAction() {
        // You can implement the logic for the ORDER button action here
        new CustomerOrderGUI().setVisible(true);

    }

    private void handleCartAction() {
        // You can implement the logic for the CART button action here
        new CustomerCartGUI().setVisible(true);

    }

    private void handleViewProductsAction() {
        // You can implement the logic for the View Products button action here
        new CustomerProductGUI().setVisible(true);
    }

    private void handleLogoutAction() {
        // You can implement the logic for the LOGOUT button action here
        JOptionPane.showMessageDialog(this, "Logging out");
        new InventoryManagementSystemGUI().setVisible(true);
        dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CustomerGUI().setVisible(true);
            }
        });
    }
}
