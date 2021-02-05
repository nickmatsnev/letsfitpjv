package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.CurrentUser;
import sample.Game;
import sample.JDBCConnector;
import sample.MegaController;

public class FindController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameAndScore;

    @FXML
    private Button findBtn;

    @FXML
    private Button createBtn;

    @FXML
    private Button ratingBtn;

    @FXML
    private Button faqBtn;

    @FXML
    private Button aboutBtn;

    @FXML
    private Button profileBtn;

    @FXML
    private Button logoutBtn;

    @FXML
    private Button exitBtn;

    @FXML
    private TextField searchInput;

    @FXML
    private Button searchBtn;

    @FXML
    private TableView<Game> outputTable;

    @FXML
    private TableColumn<Game, String> nameColumn;

    @FXML
    private TableColumn<Game, Integer> scoreColumn;

    @FXML
    private TableColumn<Game, String> creatorColumn;

    @FXML
    void initialize() {
        assert nameAndScore != null : "fx:id=\"nameAndScore\" was not injected: check your FXML file 'findGame.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert createBtn != null : "fx:id=\"createBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert ratingBtn != null : "fx:id=\"ratingBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert faqBtn != null : "fx:id=\"faqBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'findGame.fxml'.";
        assert searchInput != null : "fx:id=\"searchInput\" was not injected: check your FXML file 'findGame.fxml'.";
        assert searchBtn != null : "fx:id=\"searchBtn\" was not injected: check your FXML file 'findGame.fxml'.";

        JDBCConnector jc = new JDBCConnector();
        MegaController mc = new MegaController();
        nameAndScore.setText(CurrentUser.getUsername() + " : " + jc.getScore(CurrentUser.getUsername()));


        outputTable.setEditable(true);
        searchBtn.setOnAction(e ->{
            if(searchInput.getText().equals("")){
                searchInput.setPromptText("First input something!");
            }
            else{
                ObservableList<Game> games = FXCollections.observableArrayList(jc.gamesByName(searchInput.getText()));
                nameColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("name"));
                scoreColumn.setCellValueFactory(new PropertyValueFactory<Game, Integer>("score"));
                creatorColumn.setCellValueFactory(new PropertyValueFactory<Game, String>("creatorName"));
                outputTable.setItems(games);
            }

        });


        aboutBtn.setOnAction(e -> {
            mc.toPage("aboutPage");
        });
        createBtn.setOnAction(e -> {
            mc.toPage("createGame");
        });
        faqBtn.setOnAction(e -> {
            mc.toPage("faqPage");
        });
        ratingBtn.setOnAction(e -> {
            mc.toPage("ratingPage");
        });
        exitBtn.setOnAction(e -> {
            mc.closePage();
        });
        logoutBtn.setOnAction(e -> {
            mc.toPage("loginPage");
        });
        profileBtn.setOnAction(e -> {
            mc.toPage("profilePage");
        });
        findBtn.setOnAction(e -> {
            mc.toPage("findGame");
        });
    }
}
