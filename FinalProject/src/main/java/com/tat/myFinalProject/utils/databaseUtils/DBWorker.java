package com.tat.myFinalProject.utils.databaseUtils;

import com.tat.myFinalProject.entity.Post;
import com.tat.myFinalProject.entity.User;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides execute simple manipulations with wordpress database.
 *
 * @author Evgeniy Titenkov.
 */
public class DBWorker {
    private static final String SQL_QUERY_SELECT_ALL_USERS =
            "SELECT ID, user_login, user_email FROM wp_users";
    private static final String SQL_QUERY_SELECT_ALL_POSTS =
            "SELECT ID, post_title FROM wp_posts";
    private static final String SQL_QUERY_INSERT_USER =
            "INSERT INTO wp_users (ID, user_login, user_pass, user_email) " +
                    "VALUE (?, ?, md5(?), ?)";
    private static final String SQL_QUERY_INSERT_USERMETA =
            "INSERT INTO wp_usermeta ( user_id, meta_key, meta_value) " +
                    "VALUE ( ?, 'wp_capabilities', ?)";
    private static final String SQL_QUERY_INSERT_POST =
            "INSERT INTO wp_posts (post_date, post_content, post_title, post_excerpt, " +
                    "post_status, to_ping, pinged, comment_status, post_type, post_content_filtered) " +
                    "VALUE ('2016-12-04', ?, ?, '', 'publish', '', '', ?, 'post', '')";

    private static DBWorker dbWorker;

    private DBWorker() {
    }

    /**
     * Returns a DBWorker object, its a Singleton class.
     *
     * @return DBWorker.
     */
    public static DBWorker getDBWorker() {
        if (dbWorker == null) {
            dbWorker = new DBWorker();
        }
        return dbWorker;
    }

    private ConnectionManager connectionManager = ConnectionManager.getConnectionManager();

    /**
     * Adds user to database.
     *
     * @param user user to add.
     * @throws SQLException if query can't be executed.
     */
    public void createUser(User user) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementForUser = null;
        PreparedStatement preparedStatementForMeta = null;
        try {
            connection = connectionManager.openConnection();
            preparedStatementForUser = connection.prepareStatement(SQL_QUERY_INSERT_USER);
            preparedStatementForUser.setString(1, user.getId());
            preparedStatementForUser.setString(2, user.getLogin());
            preparedStatementForUser.setString(3, user.getPassword());
            preparedStatementForUser.setString(4, user.getEmail());
            preparedStatementForUser.executeUpdate();
            preparedStatementForMeta = connection.prepareStatement(SQL_QUERY_INSERT_USERMETA);
            preparedStatementForMeta.setString(1, user.getId());
            preparedStatementForMeta.setString(2, user.getCapabilities());
            preparedStatementForMeta.executeUpdate();
        } finally {
            DBResourcesManager.closeJdbcResources(preparedStatementForUser, null);
            DBResourcesManager.closeJdbcResources(preparedStatementForMeta, null);
            connectionManager.closeConnection(connection);
        }
    }

    /**
     * Adds post to database.
     *
     * @param post user to add.
     * @throws SQLException if query can't be executed.
     */
    public void createPost(Post post) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatementForUser = null;
        try {
            connection = connectionManager.openConnection();
            preparedStatementForUser = connection.prepareStatement(SQL_QUERY_INSERT_POST);
            preparedStatementForUser.setString(1, post.getContent());
            preparedStatementForUser.setString(2, post.getTitle());
            preparedStatementForUser.setString(3, post.getStatus());
            preparedStatementForUser.executeUpdate();
        } finally {
            DBResourcesManager.closeJdbcResources(preparedStatementForUser, null);
            connectionManager.closeConnection(connection);
        }
    }

    /**
     * Allows you to execute insert query.
     *
     * @param query query to execut.
     * @throws SQLException if query can't be executed.
     */
    public int executeInsertQuery(String query) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = connectionManager.openConnection();
            statement = connection.createStatement();
            statement.executeUpdate(query);
            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            return 0;
        } finally {
            DBResourcesManager.closeJdbcResources(statement, resultSet);
            connectionManager.closeConnection(connection);
        }
    }

    /**
     * Returns list of all user from database.
     * Every user contain id, login, and email.
     *
     * @return list of users.
     * @throws SQLException if query can't be executed.
     */
    public List<User> getUsers() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> users = new ArrayList<>();
        try {
            connection = connectionManager.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_SELECT_ALL_USERS);

            while (resultSet.next()) {
                users.add(userMapRow(resultSet));
            }
        } finally {
            DBResourcesManager.closeJdbcResources(statement, resultSet);
            connectionManager.closeConnection(connection);
        }
        return users;
    }

    /**
     * Returns list of all post from database.
     * Every posts contain id and title.
     *
     * @return list of posts.
     * @throws SQLException if query can't be executed.
     */
    public List<Post> getPosts() throws SQLException {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Post> posts = new ArrayList<>();
        try {
            connection = connectionManager.openConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SQL_QUERY_INSERT_POST);
            while (resultSet.next()) {
                posts.add(postMapRow(resultSet));
            }
        } finally {
            DBResourcesManager.closeJdbcResources(statement, resultSet);
            connectionManager.closeConnection(connection);
        }
        return posts;
    }

    /**
     * Allows you to restore database from dump file.
     *
     * @param filePath - path to dump file.
     * @throws SQLException if restore can't be executed.
     */
    public void dataImport(String filePath) throws SQLException {
        Connection connection = null;
        Statement statement = null;
        StringBuilder query = new StringBuilder();
        try {
            connection = connectionManager.openConnection();
            statement = connection.createStatement();
            BufferedReader bf = new BufferedReader(new FileReader(new File(filePath)));
            String line = null;
            line = bf.readLine();
            while (line != null) {
                if (line.endsWith(";")) {
                    statement.executeUpdate(query.append(line).toString());
                    query.setLength(0);
                } else {
                    query.append("\n").append(line);
                }
                line = bf.readLine();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            DBResourcesManager.closeJdbcResources(statement, null);
            connectionManager.closeConnection(connection);
        }
    }

    private User userMapRow(ResultSet resultSet) throws SQLException {
        return new User(
                resultSet.getString("ID"),
                resultSet.getString("user_login"),
                resultSet.getString("user_email")
        );
    }

    private Post postMapRow(ResultSet resultSet) throws SQLException {
        return new Post(
                resultSet.getString("post_title"),
                resultSet.getString("ID")
        );
    }
}
