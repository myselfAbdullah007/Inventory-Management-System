package dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

//    // Example usage
//    public static void main(String[] args) {
//        CustomerAuthenticationDAO authDAO = new CustomerAuthenticationDAO();
//        
//        // Example customer credentials
//        int customerID = 1003;
//        String password = "ABC1001";
//
//        // Authenticate customer
//        boolean isAuthenticated = authDAO.authenticateCustomer(customerID, password);
//
//        if (isAuthenticated) {
//            System.out.println("Customer is authenticated.");
//        } else {
//            System.out.println("Invalid credentials. Customer not registered.");
//        }
//    }
}
