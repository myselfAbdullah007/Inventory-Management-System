package PL;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Products extends JFrame {
    private JTable dataTable;
    private DefaultTableModel tableModel;

    public Products() {
        super("Products");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 400);
        setLocationRelativeTo(null);

        // Create components
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Price");
        tableModel.addColumn("Quantity");

        dataTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(dataTable);

        JButton addButton = new JButton("Add Product");
        JButton removeButton = new JButton("Remove Product");

        // Set layout
        setLayout(new BorderLayout());

        // Add components to the frame
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);

        add(buttonPanel, BorderLayout.SOUTH);

        // Add action listeners to the buttons
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addRow();
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeRow();
            }
        });
    }

    private void addRow() {
        Object[] rowData = {"Data 1", "Data 2", "Data 3"};
        tableModel.addRow(rowData);
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
