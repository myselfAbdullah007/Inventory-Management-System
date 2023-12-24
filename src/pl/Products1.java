package pl;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

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
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameField;
	private JTextField quantityField;
	private JTextField priceField;
	private JTextField descriptionField;
	private JTextField categoryField;
	private JTextArea resultArea;

	public Add(Products1 Presenter) {

		setLayout(new BorderLayout());

		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout((FlowLayout.LEADING)));

		JButton addButton = new JButton("ENTER");
		JLabel nameLabel = new JLabel("PRODUCT NAME");
		JLabel quantityLabel = new JLabel("QUANTITY");
		JLabel priceLabel = new JLabel("PRICE");
		JLabel descriptionLabel = new JLabel("DESCRIPTION");
		JLabel categoryLabel = new JLabel("CATEGORY");
		quantityField = new JTextField(20);
		priceField = new JTextField(20);
		descriptionField = new JTextField(20);
		categoryField = new JTextField(20);
		nameField = new JTextField(20);

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
					Float price =Float.parseFloat(priceField.getText());
					String description = descriptionField.getText();
					String category = categoryField.getText();
					Presenter.getBl().addProducts(name,quantity,price,description,category);
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

		// Creating the JTable and adding it to the panel
		String[] columnNames = { "RootName" };
		Object[][] data = new Object[0][];
		table = new JTable(data, columnNames) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false; // Make all cells non-editable
			}
		};
		JScrollPane scrollPane = new JScrollPane(table);
		add(scrollPane, BorderLayout.CENTER);
	}

	public void refreshTable() {
		// Refresh the JTable with updated data from the BLL
		List<Object[]> roots = rootPresenter.getBl().viewProducts();
		Object[][] data = new Object[roots.size()][3];
		for (int i = 0; i < roots.size(); i++) {
			data[i] = roots.get(i);
		}
	}
}
// Class OF Update Root Functionality
	class Update extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextField oldnameField;
		private JTextField nameField;
		private JTextArea resultArea;

		public Update(Products1 Presenter) {
			setLayout(new BorderLayout());

			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new FlowLayout((FlowLayout.RIGHT)));

			JButton updateButton = new JButton("ENTER");
			JLabel oldnameLabel = new JLabel("OLD PRODUCT NAME");
			JLabel nameLabel = new JLabel("UPDATED PRODUCT NAME");

			oldnameField = new JTextField(20);
			nameField = new JTextField(20);

			inputPanel.add(oldnameLabel);
			inputPanel.add(oldnameField);
			inputPanel.add(nameLabel);
			inputPanel.add(nameField);
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

						boolean success = Presenter.getBl().updateProducts(oldname, name);
						if (success) {
							resultArea.setText("UPDATED SUCCESSFULLY");
						} else {
							resultArea.setText("NOT UPDATED SUCCESSFULLY");
						}
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

// Class OF Delete Root Functionality
	class Delete extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private JTextField nameField;
		private JTextArea resultArea;

		public Delete(Products1 Presenter) {
			setLayout(new BorderLayout());

			JPanel inputPanel = new JPanel();
			inputPanel.setLayout(new FlowLayout((FlowLayout.LEADING)));

			JButton deleteButton = new JButton("ENTER");
			JLabel nameLabel = new JLabel("ENTER PRODUCT NAME");

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
						boolean success = Presenter.getBl().removeProducts(name);
						if (success) {
							resultArea.setText("DELETED SUCCESSFULLY");
						} else {
							resultArea.setText("NOT DELETED SUCCESSFULLY");
						}
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