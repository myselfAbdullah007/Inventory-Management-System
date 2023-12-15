package PL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Reports extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public Reports() {
        super("Reports");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        // Create components
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Report Name");
        tableModel.addColumn("Date");

        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        JButton removeButton = new JButton("Delete Reports");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRow();
            }
        });
    }

    private void removeRow() {
        int selectedRow = dataTable.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a row to remove.", "Row Removal", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void runn() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Products().setVisible(true);
            }
        });
    }
}


