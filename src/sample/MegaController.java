package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MegaController {
    public static Stage prevStage;

    public static void setPrevStage(Stage prevStage) {
        MegaController.prevStage = prevStage;
    }

    public void toFaq(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/Faq.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);
    }

    public void toAbout(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/About.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);
    }

    public void toFindGames(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/FindGame.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);

    }

    public void toCreateGame(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/CreateGame.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);

    }

    public void toProfile(){
        prevStage.close();
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
        stage.setResizable(false);
        setPrevStage(stage);

    }

    public void toRegister(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/registerPage.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);

    }

    public void toLogin(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/loginPage.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);

    }

    public void toGame(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/victorinePage.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);

    }

    public void toRating(){
        prevStage.close();
        Stage stage = new Stage();
        stage.setTitle("Profile");
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/Rating.fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
        stage.setResizable(false);
        setPrevStage(stage);
    }
}
