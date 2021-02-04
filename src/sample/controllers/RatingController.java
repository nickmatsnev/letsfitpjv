package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.MegaController;

public class RatingController {

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
    private TableColumn<?, ?> usernameColumn;

    @FXML
    private TableColumn<?, ?> ratingColumn;

    @FXML
    private TableView<?> ratingGameColumn;

    @FXML
    private TableColumn<?, ?> nameGameColumn;

    @FXML
    void initialize() {
        assert nameAndScore != null : "fx:id=\"nameAndScore\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert createBtn != null : "fx:id=\"createBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert ratingBtn != null : "fx:id=\"ratingBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert faqBtn != null : "fx:id=\"faqBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert usernameColumn != null : "fx:id=\"usernameColumn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert ratingColumn != null : "fx:id=\"ratingColumn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert ratingGameColumn != null : "fx:id=\"ratingGameColumn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        assert nameGameColumn != null : "fx:id=\"nameGameColumn\" was not injected: check your FXML file 'ratingPage.fxml'.";
        aboutBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("aboutPage");
        });
        createBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("createGame");
        });
        faqBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("faqPage");
        });
        ratingBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("ratingPage");
        });
        exitBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.closePage();
        });
        logoutBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("loginPage");
        });
        profileBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("profilePage");
        });
        findBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("findGame");
        });
    }
}
