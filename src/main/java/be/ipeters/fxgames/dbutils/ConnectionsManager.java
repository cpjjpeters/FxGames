package be.ipeters.fxgames.dbutils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionsManager {


    private static final String URL = "jdbc:mysql://localhost:3306/games";
    private static Connection connection;
    public static Connection getConnection() {

        if (connection == null) {
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL, "cpbelcar", "");
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void closeConnection() {

        if (connection != null) {

            try {


                connection.close();

            } catch (SQLException e) {

                // TODO Auto-generated catch block

                e.printStackTrace();

            }

        }

    }

}