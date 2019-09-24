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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GameView2Controller implements Initializable {
    @FXML
    private Button btnReturn, btnExit;
    @FXML
    private void handleBtnExitAction(ActionEvent event){
        Platform.exit();
    }

    public void back2StartScreenButtonPushed(ActionEvent event) throws IOException
    {
        Parent startParent = FXMLLoader.load(getClass().getResource("/Start.fxml"));
        Scene startScene = new Scene(startParent);

        //This line gets the Stage information
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        window.setScene(startScene);
        window.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
