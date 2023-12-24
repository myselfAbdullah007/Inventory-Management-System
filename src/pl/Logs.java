package pl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Logs extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public Logs() {
        super("Logs");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        // Create components
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Time");
        tableModel.addColumn("Log Type");
        tableModel.addColumn("Description");

        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        add(buttonPanel, BorderLayout.SOUTH);
        
        loadDataFromTextFile();
        
    }
    
    private void loadDataFromTextFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("logs/applicationlogs"))) {
            String line;
            while ((line = br.readLine()) != null) {
            	String[] data = line.split("\\s+", 3);
                tableModel.addRow(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    

    public void runn() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Logs().setVisible(true);
            }
        });
    }
}

