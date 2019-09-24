package be.ipeters.fxgames.main;

import be.ipeters.fxgames.datamodel.Game;
import be.ipeters.fxgames.dbutils.DbHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ResourceBundle;

public class GameViewController implements Initializable {
    private boolean isPossible=true;
    @FXML
    private Label label;

    @FXML
    private Button loadBtn, btnExit, refreshBtn;

    @FXML
    private TableView<Game> tvProduct;
    @FXML
    private TableColumn<Game,Integer> colGameName;
    @FXML
    private TableColumn<Game,String> colEditor;
    // variables
    private Connection conn;
    private ObservableList<Game> list = FXCollections.observableArrayList();
    // DbHandler is the connection class

    private DbHandler dbHandler;

    public void loadTable() {
        list.clear();
        System.out.println("list.clear");
        populateTabelView();
    }
    // method to populate TableView
    private void populateTabelView(){
        System.out.println("starting populateTabelView()");
        // select query string
        String query = "SELECT * FROM game";
        // run query and put results in resultset
        try {
            conn= dbHandler.getConnect();
            System.out.println("conn="+conn);
            ResultSet set = conn.createStatement().executeQuery(query);
            // loop through resultset, extract data and append to our list

            while(set.next()){
                // create an product object, add data etc
                Game game = new Game();
//                game.setId(set.getInt("id"));
                game.setGameName((set.getString("game_name")));
                game.setEditor(set.getString("editor"));

                list.add(game);
                isPossible=true;
            }
            if(list.size()==0) {
                System.out.println("No products found");
                isPossible=false;
            }
            if(isPossible) {

//                colGameName.setCellValueFactory(new PropertyValueFactory<Game, String>("game_name"));
                colEditor.setCellValueFactory(new PropertyValueFactory<Game,String>("editor"));

                // set data to tableview
                System.out.println("tvGame.setItems(list)");
                tvProduct.setItems(list);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public void refreshTable() {
        loadButtons();
        list.clear();
        // select query string
        String query = "SELECT * FROM game";
        // run query and put results in resultset
        try {
            conn= dbHandler.getConnect();
            ResultSet set = conn.createStatement().executeQuery(query);
            // loop through resultset, extract data and append to our list

            while(set.next()){
                // create an product object, add data etc
                Game game = new Game();
//                game.setId(set.getInt("id"));
                game.setGameName((set.getString("game_name")));
                game.setEditor((set.getString("editor")));

//                System.out.println("set.next product");
                list.add(game);
                isPossible=true;
            }
            if(list.size()==0) {
                System.out.println("No products found");
                isPossible=false;
            }
            if(isPossible) {
//                colId.setCellValueFactory(new PropertyValueFactory<Game, Integer>("id"));
//                colGameName.setCellValueFactory(new PropertyValueFactory<Game, String>("game_name"));
                colEditor.setCellValueFactory(new PropertyValueFactory<Game,String>("editor"));
//                colStock.setCellValueFactory(new PropertyValueFactory<Game, Integer>("stock"));
                // set data to tableview
                System.out.println("refreshTable -- tvGame.setItems(list)");
                tvProduct.setItems(list);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void handleBtnExitAction(ActionEvent event){
        Platform.exit();
    }
    @FXML
    private void loadButtons(){
        if(refreshBtn.getText().equalsIgnoreCase("refresh")) {
            refreshBtn.setText("ReFrEsH 1");
        }else {
            refreshBtn.setText("REFRESH");
        }

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
