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
import java.util.ResourceBundle;


public class StartController implements Initializable {
    @FXML
    private Label label;
    @FXML
    private TextField usernameTextField;
    @FXML
    private Button btnStart, btnExit, btnNext;
    @FXML
    private PasswordField pwfield1;

    @FXML
    private void handleButtonAction(ActionEvent event){
        String username = usernameTextField.getText();
        String password = pwfield1.getText();
        if(username.equals("javafx") && password.equals("letmepass") ){
            label.setText("you shall pass!");
        }else
        {
            label.setText(" no no");
        }
        System.out.println("you clicked START !");
//        label.setText("pass");
    }
    /**
     * When this method is called, it will change the Scene to
     * a TableView example
     */
    public void changeScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("ExampleOfTableView.fxml"));
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