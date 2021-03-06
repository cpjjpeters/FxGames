package be.ipeters.fxgames.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FxGameRunner extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/Start.fxml"));
        primaryStage.setTitle("FX Games");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        MySQLAccess dao = new MySQLAccess();
        try {
            dao.readDataBase();
            launch(args);
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}
