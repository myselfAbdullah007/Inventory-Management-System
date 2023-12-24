package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DTO.Product;

public class ProductDAO {

    public List<Product> getAllProducts() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        List<Product> products = new ArrayList<>();

        try {
            // Get the database connection
            DatabaseConnection dbInstance = DatabaseConnection.getInstance();
            connection = dbInstance.getConnection();

            // Prepare the SQL statement
            String sql = "SELECT * FROM products";
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Process the result set
            while (resultSet.next()) {
                String productId = resultSet.getString("ProductID");
                String name = resultSet.getString("ProductName");
                String description = resultSet.getString("Description");
                String price = resultSet.getString("Price");

                // Create a Product object and add it to the list
                Product product = new Product(productId, name, description, price);
                products.add(product);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Error retrieving products from the database");
        } finally {
            // Close resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                DatabaseConnection.getInstance().closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return products;
    }
    
    public void addToCart(String productId, String customerName) {
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();

        // Implement the logic to add the selected product to the cart in the database
        // You may need to update the method signature based on your database schema and requirements
        String addToCartQuery = "INSERT INTO cart (ProductID, CustomerID) VALUES (?, ?)";
        try (Connection connection = dbInstance.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(addToCartQuery)) {
            preparedStatement.setString(1, productId);
            preparedStatement.setString(2, customerName);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception as needed
        }
    }
}
