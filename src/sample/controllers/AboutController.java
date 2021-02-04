package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import sample.CurrentUser;
import sample.JDBCConnector;
import sample.MegaController;
import sample.Switcher;

public class AboutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    private Label nameAndScoreLabel;

    @FXML
    void initialize() {
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert createBtn != null : "fx:id=\"createBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert ratingBtn != null : "fx:id=\"ratingBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert faqBtn != null : "fx:id=\"faqBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'aboutPage.fxml'.";

        JDBCConnector jc = new JDBCConnector();
        MegaController mc = new MegaController();
        nameAndScoreLabel.setText(CurrentUser.getUsername() + " : " + jc.getScore(CurrentUser.getUsername()));

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
