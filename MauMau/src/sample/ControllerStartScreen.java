package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;

public class ControllerStartScreen {
    public Button playBTN;
    public Button gameInfoBTN;

    public void initialize(){
        playBTN.setOnAction(actionEvent -> {
            Main.PRIMARYSTAGE.setTitle("MauMau");
            Main.PRIMARYSTAGE.setScene(new Scene(Main.rootPlayScreen, 843, 534));
            Main.PRIMARYSTAGE.show();
        });

        playBTN.setOnMouseEntered(actionEvent -> {
            playBTN.setStyle("-fx-background-color: #20b5d9; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
        });

        playBTN.setOnMouseExited(actionEvent -> {
            playBTN.setStyle("-fx-background-color: #41d9c4; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
        });

        gameInfoBTN.setOnAction(actionEvent -> {
            System.out.println("info");
        });

        gameInfoBTN.setOnMouseEntered(actionEvent -> {
            gameInfoBTN.setStyle("-fx-background-color: #20b5d9; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
        });

        gameInfoBTN.setOnMouseExited(actionEvent -> {
            gameInfoBTN.setStyle("-fx-background-color: #41d9c4; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
        });

    }



}
