package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class MegaController {
    public static Stage prevStage;

    public static void setPrevStage(Stage prevStage) {
        MegaController.prevStage = prevStage;
    }

    public void closePage(){
        if(prevStage != null){
            prevStage.close();
        }
    }

    /**
     *
     * @param page
     */
    public void toPage(String page){
        if(prevStage != null){
            prevStage.close();
        }
        Stage stage = new Stage();
        stage.setTitle(page);
        Parent myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("design/" + page + ".fxml"));
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
