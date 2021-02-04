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
    private Label ifincorrectLabel;

    @FXML
    void initialize() {
        assert usernameInput != null : "fx:id=\"usernameInput\" was not injected: check your FXML file 'registerPage.fxml'.";
        assert passwordInput != null : "fx:id=\"passwordInput\" was not injected: check your FXML file 'registerPage.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'registerPage.fxml'.";
        assert repeatInput != null : "fx:id=\"repeatInput\" was not injected: check your FXML file 'registerPage.fxml'.";

        loginBtn.setOnAction(e ->{
            if(usernameInput.getText().equals("")
                    || passwordInput.getText().equals("")
                    || repeatInput.getText().equals("")){
                ifincorrectLabel.setText("Please, fill all the fields!");
            }
            else{
                JDBCConnector c = new JDBCConnector();
                MegaController mc = new MegaController();

                if(passwordInput.getText().equals(repeatInput.getText())){
                    c.setNewUser(usernameInput.getText(), passwordInput.getText());

                    CurrentUser.setUsername(usernameInput.getText());
                    CurrentUser.setPassword(passwordInput.getText());
                    CurrentUser.setScore(0);

                    mc.toPage("profilePage");
                }
                else{
                    ifincorrectLabel.setText("Your password is not the same after repetition.");
                }

            }
        });
    }
}