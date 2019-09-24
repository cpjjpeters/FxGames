package be.ipeters.fxgames.main;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;


public class StartController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button  btnExit, btnNext, btnLogin,btnGameTV;
    @FXML
    private PasswordField pwfield1;
    @FXML
    private void handleLoginButtonAction(ActionEvent event){
        String username = usernameTextField.getText();
        String password = pwfield1.getText();
        if(username.equals("javafx") && password.equals("letmepass") ){
            label.setText("you shall pass!");
        }else
        {
            label.setText(" no no");
        }
        System.out.println("you clicked LOGIN !");
        if (isValidCredentials())
        {
            label.setText("you shall pass!");
        }else
        {
            label.setText(" no no");
        }
//        label.setText("pass");
    }



    private static final String URL = "jdbc:mysql://localhost:3306/games";
    private boolean isValidCredentials() {
        boolean let_in = false;
        String username = usernameTextField.getText();
        String password = pwfield1.getText();
        System.out.println( "SELECT * FROM users WHERE USERNAME= " + "'" + username+ "'"
                + " AND PASSWORD= " + "'" + password+ "'" );

        Connection c = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(URL, "cpbelcar", "");
            c.setAutoCommit(false);

            System.out.println("Opened database successfully");
            stmt = c.createStatement();

            ResultSet rs = stmt.executeQuery( "SELECT * FROM users WHERE USERNAME= " + "'" + username + "'"
                    + " AND PASSWORD= " + "'" + password+ "'");

            while ( rs.next() ) {
                if (rs.getString("USERNAME") != null && rs.getString("PASSWORD") != null) {
                    String  dbusername = rs.getString("USERNAME");
                    System.out.println( "USERNAME = " + dbusername );
                    String dbpassword = rs.getString("PASSWORD");
                    System.out.println("PASSWORD = " + dbpassword);
                    let_in = true;
                }
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Operation done successfully");
        return let_in;

    }

    /**
     * When this method is called, it will change the Scene to
     * a TableView example
     */
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/ExampleOfTableView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    /**
     * When this method is called, it will change the Scene to
     * a TableView example
     */
    public void change2GameScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/GameView.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }

    public void change2GameView2ButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("/GameView2.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }
    @FXML
    private void handleBtnExitAction(ActionEvent event){
        Platform.exit();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}