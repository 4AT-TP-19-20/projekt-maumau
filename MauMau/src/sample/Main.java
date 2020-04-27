package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static Stage PRIMARYSTAGE;
    public static Parent rootStartScreen, rootPlayScreen;

    @Override
    public void start(Stage startStage) throws Exception {

        PRIMARYSTAGE = startStage;
        PRIMARYSTAGE.setResizable(false);

        rootStartScreen = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        rootPlayScreen = FXMLLoader.load(getClass().getResource("PlayScreen.fxml"));

        Parent root = FXMLLoader.load(getClass().getResource("StartScreen.fxml"));
        startStage.setTitle("MauMau");
        startStage.setScene(new Scene(root, 620, 420));
        startStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
