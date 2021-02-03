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
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.Main;
import sample.MegaController;
import sample.Switcher;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField inputUser;

    @FXML
    private Hyperlink registerLabel;

    @FXML
    private TextField inputPassword;

    @FXML
    private Button loginBtn;
    @FXML
    void initialize() throws IOException{

        MegaController mc = new MegaController();
        assert inputUser != null : "fx:id=\"inputUser\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert inputPassword != null : "fx:id=\"inputPassword\" was not injected: check your FXML file 'loginPage.fxml'.";
        assert loginBtn != null : "fx:id=\"loginBtn\" was not injected: check your FXML file 'loginPage.fxml'.";
        registerLabel.setOnKeyPressed(e ->{
            mc.toPage("registerPage");
        });
        loginBtn.setOnAction(e -> {
            mc.toPage("registerPage");
            /*Stage stage = new Stage();
            stage.setTitle("Profile");
            Pane myPane = null;
            try {
                myPane = FXMLLoader.load(getClass().getResource("../design/profilePage.fxml"));
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Scene scene = new Scene(myPane);
            stage.setScene(scene);
            stage.show(); */
            mc.toPage("profilePage");
            //working example of switchin

        });

    }
}
