package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.*;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputUser;


    @FXML
    private TextField inputPassword;

    @FXML
    private Button loginBtn;
    @FXML
    private Button registerBtn;

    @FXML
    private Label ifIncorrectLabel;
    @FXML
    void initialize() throws IOException{

        MegaController mc = new MegaController();
        JDBCConnector jc = new JDBCConnector();

        assert inputUser != null : "fx:id=\"inputUser\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert inputPassword != null : "fx:id=\"inputPassword\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'loginPage.fxml'.";

        registerBtn.setOnAction(e -> {
            mc.toPage("registerPage");
        });

        loginBtn.setOnAction(e -> {
            if(jc.loginCheck(inputUser.getText(), inputPassword.getText())){
                mc.toPage("profilePage");
                CurrentUser.setUsername(inputUser.getText());
                CurrentUser.setPassword(inputPassword.getText());
            }
            else{
                ifIncorrectLabel.setText("Sth wrong");
            }

        });

    }
}
