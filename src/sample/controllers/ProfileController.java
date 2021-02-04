package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.CurrentUser;
import sample.JDBCConnector;
import sample.MegaController;

public class ProfileController {

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
    private Label usernameLabel;

    @FXML
    private Label playedGamesScore;

    @FXML
    private Label createdGamesScore;

    @FXML
    private Label mostPopularGame;

    @FXML
    private TextField oldPasswordInput;

    @FXML
    private TextField newPasswordInput;

    @FXML
    private TextField repeatPasswordInput;

    @FXML
    private Button resetBtn;

    @FXML
    void initialize() {
        assert nameAndScore != null : "fx:id=\"nameAndScore\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert createBtn != null : "fx:id=\"createBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert ratingBtn != null : "fx:id=\"ratingBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert faqBtn != null : "fx:id=\"faqBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert usernameLabel != null : "fx:id=\"usernameLabel\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert playedGamesScore != null : "fx:id=\"playedGamesScore\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert createdGamesScore != null : "fx:id=\"createdGamesScore\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert mostPopularGame != null : "fx:id=\"mostPopularGame\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert oldPasswordInput != null : "fx:id=\"oldPasswordInput\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert newPasswordInput != null : "fx:id=\"newPasswordInput\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert repeatPasswordInput != null : "fx:id=\"repeatPasswordInput\" was not injected: check your FXML file 'profilePage.fxml'.";
        assert resetBtn != null : "fx:id=\"resetBtn\" was not injected: check your FXML file 'profilePage.fxml'.";

        JDBCConnector jc = new JDBCConnector();
        nameAndScore.setText(CurrentUser.getUsername() + " : " + jc.getScore(CurrentUser.getUsername()));
        MegaController mc = new MegaController();

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
