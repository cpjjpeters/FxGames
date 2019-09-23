package be.ipeters.fxgames.main;

import be.ipeters.fxgames.datamodel.Game;
import be.ipeters.fxgames.dbutils.DbHandler;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

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
    private TextField usernameTextField;
    @FXML
    private Button loadBtn, btnExit, refreshBtn;
    @FXML
    private PasswordField pwfield1;
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
        populateTabelView();
    }
    // method to populate TableView
    private void populateTabelView(){
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
                game.setId(set.getInt("id"));
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
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
