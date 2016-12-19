package com.tat.myFinalProject.utils.databaseUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Provides static functionality of database resource management.
 *
 * @author Evgeny Titenkov
 */
public class DBResourcesManager {
    /**
     * Provides to close objects of Statement and ResultSet.
     *
     * @param statement Statement object.
     * @param resultSet ResultSet oject.
     * @throws SQLException
     */
    public static void closeJdbcResources(Statement statement, ResultSet resultSet)
            throws SQLException {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } finally {
            if (statement != null) {
                statement.close();
            }
        }
    }
}
