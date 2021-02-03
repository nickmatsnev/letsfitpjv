package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Switcher {
    public static String switcher;

    public static void setSwitcher(String switcher) {
        Switcher.switcher = switcher;
    }

    public static String getSwitcher() {
        return switcher;
    }
    public void onClickOpen(String nameOfDesign){
        Stage stage = new Stage();
        stage.setTitle(nameOfDesign);
        Pane myPane = null;
        try {
            myPane = FXMLLoader.load(getClass().getResource("../design/" + nameOfDesign + ".fxml"));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        Scene scene = new Scene(myPane);
        stage.setScene(scene);
        stage.show();
    }
    public void onClickClose(Stage stage){
        stage.close();
    }
}
