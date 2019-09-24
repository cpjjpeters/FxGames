package be.ipeters.fxgames.main;

import java.sql.*;

public class MySQLAccess {
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/games?" + "user=cpbelcar&password=");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from games.game");
            writeResultSetGame(resultSet);

        }catch (Exception e){
            throw e;
        }finally {
            close();
        }
    }

    private void writeResultSetGame(ResultSet resultSet) throws SQLException {
        //
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String game_name = resultSet.getString("game_name");
            String editor = resultSet.getString("editor");
            System.out.println("game_name= "+game_name);
        }
    }
    private void close(){
        try {
            if(resultSet!=null){
                resultSet.close();
            }
            if(statement != null){
                statement.close();
            }
            if(connection != null){
                connection.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
