package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author [Ehsan Tanvir]
 * @version 2.0
 * @since [26-10-2023]
 */
public class ProductsDAO {

	public void addProducts(String name, Integer quantity, Float price, String description, String category) {
		try {
			Connection connection = DatabaseConnection.getInstance().getConnection();
			String insertQuery = "INSERT INTO products (ProductName,Quantity,Price,Description,Category) VALUES (?, ?, ?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, quantity);
			preparedStatement.setFloat(3, price);
			preparedStatement.setString(4, description);
			preparedStatement.setString(5, category);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Object[]> viewProducts() {
		List<Object[]> products = new ArrayList<>();

		try {
			Connection connection = DatabaseConnection.getInstance().getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM products");
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				String name = resultSet.getString("ProductName");
				Integer quantity = resultSet.getInt("Quantity");
				Float price = resultSet.getFloat("Price");
				String description = resultSet.getString("Description");
				String category = resultSet.getString("Category");
				
				Object[] productsData = { name,quantity,price,description,category };
				products.add(productsData);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}

	public boolean updateProducts(String oldname ,String name, Integer quantity, Float price, String description, String category) {
		boolean updated = false;

		try {
			Connection connection = DatabaseConnection.getInstance().getConnection();
			String checkQuery = "SELECT 1 FROM products WHERE name = ? LIMIT 1";
			PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
			checkStatement.setString(1, oldname);
			ResultSet result = checkStatement.executeQuery();

			if (result.next()) {
				String updateQuery = "UPDATE books SET ProductName = ?, Quantity = ?, Price = ? , Description = ?, Category = ? WHERE  ProductName = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, quantity);
				preparedStatement.setFloat(3, price);
				preparedStatement.setString(4, description);
				preparedStatement.setString(5, category);
				preparedStatement.setString(6, oldname);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				updated = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return updated;
	}

	public boolean deleteProducts(String name) {
		boolean deleted = false;
		try {
			Connection connection = DatabaseConnection.getInstance().getConnection();
			String checkQuery = "SELECT 1 FROM products WHERE ProductName = ? LIMIT 1";
			PreparedStatement checkStatement = connection.prepareStatement(checkQuery);
			checkStatement.setString(1, name);
			ResultSet result = checkStatement.executeQuery();

			if (result.next()) {
				String deleteQuery = "DELETE FROM productss WHERE ProductName = ?";
				PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
				preparedStatement.setString(1, title);
				preparedStatement.executeUpdate();
				preparedStatement.close();
				deleted = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return deleted;
	}
}