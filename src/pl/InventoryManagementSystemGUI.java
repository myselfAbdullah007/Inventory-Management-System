package pl;
import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryManagementSystemGUI extends JFrame {

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

    public InventoryManagementSystemGUI() {
        // Set up the main frame
        setTitle("Inventory Management System");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create components
        JLabel titleLabel = new JLabel("Welcome to Inventory Management System");
		titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Frame frame = new Frame();
		frame.add(titleLabel, BorderLayout.PAGE_START);
        JButton adminButton = new JButton("Admin Module");
        JButton customerButton = new JButton("Customer Module");

        // Set preferred button size
        Dimension buttonSize = new Dimension(150, 50);
        adminButton.setPreferredSize(buttonSize);
        customerButton.setPreferredSize(buttonSize);

        // Set layout manager
        setLayout(new GridBagLayout());

        // Create constraints for centering
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Add components to the frame with constraints
        add(titleLabel, gbc);

        gbc.gridy = 1;
        add(adminButton, gbc);

        gbc.gridy = 2;
        add(customerButton, gbc);

        // Add action listeners
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Admin Module
            	new AdminLogin().setVisible(true);
            }
        });

        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Open Customer Module
				new Login().setVisible(true);
            }
        });
    }

    private void openAdminModule() {
        // You can implement the Admin Module logic here
        JOptionPane.showMessageDialog(this, "Opening Admin Module");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new InventoryManagementSystemGUI().setVisible(true);
            }
        });
    }
}
