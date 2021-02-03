package sample.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField usernameInput;

    @FXML
    private TextField passwordInput;

    @FXML
    private Button loginBtn;

    @FXML
    private TextField repeatInput;

    @FXML
    void initialize() {
        assert usernameInput != null : "fx:id=\"usernameInput\" was not injected: check your FXML file 'registerPage.fxml'.";
        assert passwordInput != null : "fx:id=\"passwordInput\" was not injected: check your FXML file 'registerPage.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'registerPage.fxml'.";
        assert repeatInput != null : "fx:id=\"repeatInput\" was not injected: check your FXML file 'registerPage.fxml'.";

    }
}