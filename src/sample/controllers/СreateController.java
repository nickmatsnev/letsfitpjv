package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.MegaController;

public class СreateController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label nameAndScoreLabel;

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
    private Button prevQuestionBtn;

    @FXML
    private Button nextQuestionBtn;

    @FXML
    private TextArea inputQuestion;

    @FXML
    private TextField correctAnswerInput;

    @FXML
    private TextField wrongOne;

    @FXML
    private TextField wrongTwo;

    @FXML
    private TextField wrongThree;

    @FXML
    private Label counterLabel;

    @FXML
    void initialize() {
        assert nameAndScoreLabel != null : "fx:id=\"nameAndScoreLabel\" was not injected: check your FXML file 'createGame.fxml'.";
        assert findBtn != null : "fx:id=\"findBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert createBtn != null : "fx:id=\"createBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert ratingBtn != null : "fx:id=\"ratingBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert faqBtn != null : "fx:id=\"faqBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert aboutBtn != null : "fx:id=\"aboutBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert profileBtn != null : "fx:id=\"profileBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert logoutBtn != null : "fx:id=\"logoutBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert exitBtn != null : "fx:id=\"exitBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert prevQuestionBtn != null : "fx:id=\"prevQuestionBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert nextQuestionBtn != null : "fx:id=\"nextQuestionBtn\" was not injected: check your FXML file 'createGame.fxml'.";
        assert inputQuestion != null : "fx:id=\"inputQuestion\" was not injected: check your FXML file 'createGame.fxml'.";
        assert correctAnswerInput != null : "fx:id=\"correctAnswerInput\" was not injected: check your FXML file 'createGame.fxml'.";
        assert wrongOne != null : "fx:id=\"wrongOne\" was not injected: check your FXML file 'createGame.fxml'.";
        assert wrongTwo != null : "fx:id=\"wrongTwo\" was not injected: check your FXML file 'createGame.fxml'.";
        assert wrongThree != null : "fx:id=\"wrongThree\" was not injected: check your FXML file 'createGame.fxml'.";
        assert counterLabel != null : "fx:id=\"counterLabel\" was not injected: check your FXML file 'createGame.fxml'.";


        aboutBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("aboutPage");
        });
        createBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("createPage");
        });
        faqBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("faqPage");
        });
        ratingBtn.setOnAction(e -> {
            MegaController mc = new MegaController();
            mc.toPage("ratingBtn");
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
