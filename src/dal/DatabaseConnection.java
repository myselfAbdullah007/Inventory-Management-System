package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import log.Log;

public class DatabaseConnection {

    // JDBC URL, username, and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/project db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // JDBC variables for opening, closing, and managing the connection
    private static Connection connection;

    // Private constructor to prevent instantiation from outside
    private DatabaseConnection() {
        // Empty private constructor to prevent instantiation
    }

    // Singleton instance
    private static DatabaseConnection instance;

    // Method to get the Singleton instance
    public static DatabaseConnection getInstance() {
        if (instance == null) {
            synchronized (DatabaseConnection.class) {
                if (instance == null) {
                    instance = new DatabaseConnection();
                }
            }
        }
        return instance;
    }

    // Method to establish a connection to the database
    public Connection getConnection() {
        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD);

            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            Log.LOGGER.error(e.getMessage());
            throw new RuntimeException("Failed to connect to the database");
        }
    }

    // Method to close the connection
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
        	Log.LOGGER.error(e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Example usage
        DatabaseConnection dbInstance = DatabaseConnection.getInstance();
        Connection dbConnection = dbInstance.getConnection();
        // Perform database operations here...

        // Close the connection when done
        dbInstance.closeConnection();
    }
}
