package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
    void initialize() throws IOException{
        assert inputUser != null : "fx:id=\"inputUser\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert inputPassword != null : "fx:id=\"inputPassword\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'loginPage.fxml'.";
        loginBtn.setOnAction(e -> {
            Stage stage = new Stage();
            stage.setTitle("Profile");
            Pane myPane = null;
            try {
                myPane = FXMLLoader.load(getClass().getResource("../design/Profile.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show();
            //working example of switchin

        });

    }
}
