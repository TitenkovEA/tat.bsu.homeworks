package com.tat.myFinalProject.utils.databaseUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Simple database Connection Manager.
 * Only provides functionality to open and close a Connection.
 *
 * @author Evgeniy Titenkov.
 */
public class ConnectionManager {
    private static final String URL = "jdbc:mysql://127.0.0.1:8889/wordpress";
    private static final String USER = "root";
    private static final String PASSWORD = "root";
    private static ConnectionManager connectionManager;

    public static ConnectionManager getConnectionManager() {
        if (connectionManager == null) {
            return connectionManager = new ConnectionManager();
        }
        return connectionManager;
    }

    private ConnectionManager() {
    }

    /**
     * Creates a Connection to a database with specified Connection properties
     * (url, username, password).
     *
     * @return established database Connection.
     */
    public Connection openConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            // Handle SQLException if such has been thrown
        }
        return connection;
    }

    /**
     * Close database Connection.
     *
     * @param connection - connection to close.
     */
    public void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            // Handle SQLException if such has been thrown
        }
    }
}
