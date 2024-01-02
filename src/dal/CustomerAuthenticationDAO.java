package dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import log.Log;

public class CustomerAuthenticationDAO {

    // Method to authenticate a customer based on provided credentials
    public boolean authenticateCustomer(String customerName, String password) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Get the database connection
        	 DatabaseConnection dbInstance = DatabaseConnection.getInstance();
             connection = dbInstance.getConnection();

            // Prepare the SQL statement
            String sql = "SELECT * FROM customers WHERE CustomerID = ? AND Password = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customerName);
            preparedStatement.setString(2, password);

            // Execute the query
            resultSet = preparedStatement.executeQuery();

            // Check if the customer is registered
            return resultSet.next();

        } catch (SQLException e) {
            e.printStackTrace();
            Log.LOGGER.error("Invalid Customer Credentials");
            throw new RuntimeException("Error authenticating customer");
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
    }
}
