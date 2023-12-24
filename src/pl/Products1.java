package pl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import dal.ProductsDAO;

/**
 * 
 *
 * @author [Ehsan Tanvir]
 * @version 2.0
 * @since [26-10-2023]
 */
public class Products1 extends JFrame {
	private static final long serialVersionUID = -1715101882915748261L;
	private Add addScreen;
	private Read readScreen;
	private Update updateScreen;
	private Delete deleteScreen;
	private CardLayout cardLayout;
	private JPanel cardPanel;
	private ProductsDAO dal;

	public Products1() {
		dal = new ProductsDAO();

		setTitle("Products");
		setSize(800, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		addScreen = new Add(this);
		readScreen = new Read(this);
		updateScreen = new Update(this);
		deleteScreen = new Delete(this);

		cardPanel.add(addScreen, "ADD");
		cardPanel.add(readScreen, "READ");
		cardPanel.add(updateScreen, "UPDATE");
		cardPanel.add(deleteScreen, "DELETE");

		JPanel buttonPanel = new JPanel(new FlowLayout());
		JButton addButton = new JButton("ADD");
		JButton readButton = new JButton("VIEW");
		JButton updateButton = new JButton("UPDATE");
		JButton deleteButton = new JButton("DELETE");

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "ADD");
			}
		});

		readButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "READ");
				readScreen.refreshTable();
			}
		});

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "UPDATE");
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cardPanel, "DELETE");
			}
		});

		buttonPanel.add(addButton);
		buttonPanel.add(readButton);
		buttonPanel.add(updateButton);
		buttonPanel.add(deleteButton);

		add(cardPanel, BorderLayout.CENTER);
		add(buttonPanel, BorderLayout.SOUTH);
	}

	public ProductsDAO getBl() {
		return dal;
	}

}

class Add extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField nameField, quantityField, priceField, descriptionField, categoryField;
	private JTextArea resultArea;

	public Add(Products1 Presenter) {
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(6, 2, 5, 5));

		JButton addButton = new JButton("ENTER");
		addButton.setBackground(new Color(50, 205, 50));
		addButton.setForeground(Color.WHITE);

		JLabel nameLabel = new JLabel("PRODUCT NAME");
		JLabel quantityLabel = new JLabel("QUANTITY");
		JLabel priceLabel = new JLabel("PRICE");
		JLabel descriptionLabel = new JLabel("DESCRIPTION");
		JLabel categoryLabel = new JLabel("CATEGORY");

		nameField = new JTextField(20);
		quantityField = new JTextField(20);
		priceField = new JTextField(20);
		descriptionField = new JTextField(20);
		categoryField = new JTextField(20);

		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(quantityLabel);
		inputPanel.add(quantityField);
		inputPanel.add(priceLabel);
		inputPanel.add(priceField);
		inputPanel.add(descriptionLabel);
		inputPanel.add(descriptionField);
		inputPanel.add(categoryLabel);
		inputPanel.add(categoryField);
		inputPanel.add(addButton);

		resultArea = new JTextArea(5, 10);
		resultArea.setEditable(false);

		add(inputPanel, BorderLayout.CENTER);

		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String name = nameField.getText();
					Integer quantity = Integer.parseInt(quantityField.getText());
					Float price = Float.parseFloat(priceField.getText());
					String description = descriptionField.getText();
					String category = categoryField.getText();
					Presenter.getBl().addProducts(name, quantity, price, description, category);
					resultArea.setText("ADDED");
				} catch (NumberFormatException ex) {
					resultArea.setText("Invalid input.");
				} catch (Exception ex) {
					resultArea.setText("An error occurred.");
				}
			}
		});

		add(resultArea, BorderLayout.NORTH);
	}
}

class Read extends JPanel {
	private static final long serialVersionUID = 1L;
	private Products1 rootPresenter;
	private JTable table;

	public Read(Products1 Presenter) {
		this.rootPresenter = Presenter;
		setLayout(new BorderLayout());

		String[] columnNames = { "Product Name", "Quantity", "Price", "Description", "Category" };
		Object[][] data = new Object[0][];
		table = new JTable(new DefaultTableModel(data, columnNames));
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setAutoCreateRowSorter(true);

		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void refreshTable() {
		List<Object[]> products = rootPresenter.getBl().viewProducts();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (Object[] product : products) {
			model.addRow(product);
		}
	}
}

class Update extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField oldnameField, nameField, quantityField, priceField, descriptionField, categoryField;
	private JTextArea resultArea;

	public Update(Products1 Presenter) {
		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(7, 2, 5, 5)); // Improved layout manager

		JButton updateButton = new JButton("UPDATE");
		updateButton.setBackground(new Color(70, 130, 180)); // Blue background color
		updateButton.setForeground(Color.WHITE); // White text color

		JLabel oldnameLabel = new JLabel("Old Product Name");
		JLabel nameLabel = new JLabel("Updated Product Name");
		JLabel quantityLabel = new JLabel("Updated Quantity");
		JLabel priceLabel = new JLabel("Updated Price");
		JLabel descriptionLabel = new JLabel("Updated Description");
		JLabel categoryLabel = new JLabel("Updated Category");

		// Styling text fields
		oldnameField = new JTextField(20);
		nameField = new JTextField(20);
		quantityField = new JTextField(20);
		priceField = new JTextField(20);
		descriptionField = new JTextField(20);
		categoryField = new JTextField(20);

		inputPanel.add(oldnameLabel);
		inputPanel.add(oldnameField);
		inputPanel.add(nameLabel);
		inputPanel.add(nameField);
		inputPanel.add(quantityLabel);
		inputPanel.add(quantityField);
		inputPanel.add(priceLabel);
		inputPanel.add(priceField);
		inputPanel.add(descriptionLabel);
		inputPanel.add(descriptionField);
		inputPanel.add(categoryLabel);
		inputPanel.add(categoryField);
		inputPanel.add(updateButton);

		resultArea = new JTextArea(5, 10);
		resultArea.setEditable(false);

		add(inputPanel, BorderLayout.CENTER);

		updateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String oldname = oldnameField.getText();
					String name = nameField.getText();
					Integer quantity = Integer.parseInt(quantityField.getText());
					Float price = Float.parseFloat(priceField.getText());
					String description = descriptionField.getText();
					String category = categoryField.getText();

					boolean success = Presenter.getBl().updateProducts(oldname, name, quantity, price, description,
							category);
					resultArea.setText(success ? "Updated Successfully" : "Not Updated Successfully");
				} catch (NumberFormatException ex) {
					resultArea.setText("Invalid input. Please check your input values.");
				} catch (Exception ex) {
					resultArea.setText("An error occurred. Please try again later.");
				}
			}
		});

		add(resultArea, BorderLayout.NORTH);
	}
}

class Delete extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTextField nameField;
    private JTextArea resultArea;

    public Delete(Products1 Presenter) {
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2, 5, 5)); // Improved layout manager

        JButton deleteButton = new JButton("DELETE");
        deleteButton.setBackground(new Color(220, 20, 60)); // Crimson background color
        deleteButton.setForeground(Color.WHITE); // White text color

        JLabel nameLabel = new JLabel("Product Name to Delete");

        // Styling text fields
        nameField = new JTextField(20);

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(deleteButton);

        resultArea = new JTextArea(5, 10);
        resultArea.setEditable(false);

        add(inputPanel, BorderLayout.CENTER);

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String name = nameField.getText();
                    boolean success = Presenter.getBl().deleteProducts(name);
                    resultArea.setText(success ? "Deleted Successfully" : "Not Deleted Successfully");
                } catch (Exception ex) {
                    resultArea.setText("An error occurred. Please try again later.");
                }
            }
        });

        add(resultArea, BorderLayout.NORTH);
    }
}