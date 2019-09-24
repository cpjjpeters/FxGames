package be.ipeters.fxgames.dbutils;

import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbHandler {
    protected Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    // connection method that returns connection instance
    public Connection getConnect() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        // Setup the connection with the DB
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost/games?" + "user=cpbelcar&password=");
            System.out.println("dbHandler connected");
        } catch (SQLException e) {
            Logger.getLogger(DbHandler.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
        return connection;
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        } catch (Exception e) {

        }
    }

}
