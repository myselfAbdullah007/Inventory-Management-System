package pl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
public class AdminGUI extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel welcomeLabel;

    public AdminGUI() {
        super("Admin");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        // Create components
        welcomeLabel = new JLabel("Welcome, Admin!", SwingConstants.CENTER);
        JButton button1 = new JButton("Manage Products");
        JButton button2 = new JButton("View Logs");
        JButton button3 = new JButton("Generate Reports");
        //JButton button4 = new JButton(" ");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(welcomeLabel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        buttonPanel.add(button3);
        //buttonPanel.add(button4);

        add(buttonPanel, BorderLayout.SOUTH);
   
        // Add action listeners to the buttons
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//Products productsGUI = new Products();
                //productsGUI.runn();
            	
            	Products1 productsGUI1 = new Products1();
    	        SwingUtilities.invokeLater(new Runnable() {
    	            public void run() {
    	            	productsGUI1.setVisible(true);
    	            }
    	        });
    		}
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Logs logsGUI = new Logs();
                logsGUI.runn();
            }
        });

        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Reports report = new Reports();
                try {
					report.createPdfWithTable("Stock.pdf");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });

    }

    @SuppressWarnings("unused")
	private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message, "Button Clicked", JOptionPane.INFORMATION_MESSAGE);
    }

    public void runn(){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AdminGUI().setVisible(true);
            }
        });
    }
}

