package sample;

import javafx.scene.Scene;
import javafx.scene.control.Button;

import javax.swing.*;

public class ControllerStartScreen {
    public Button playBTN;
    public Button gameInfoBTN;

    public void initialize() {
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
            JOptionPane.showMessageDialog(null, "Developed by: HausiPhileMez inc.\n\n--------------------------------Spiel Info--------------------------------\n" +
                    "- Um ein Spiel zu Starten, drücken Sie den \"Play\" Button.\n" +
                    "- Anschließend werden Sie zur Spieloberfläche weitergeleitet.\n" +
                    "- Am rechten oberen Bereich der Spieleoberfläche befindet sich ein Start Knopf.\n" +
                    "- Wenn dieser Betätigt wurde werden Sie aufgefordert Ihren Namen einzugeben.\n" +
                    "- Als dieser Schritt abgeschlossen wurde beginnt das Spiel.\n" +
                    "- Als Erstes liegt eine offene Karte auf. \n" +
                    "- Im unteren Bereich der Spieleoberfläche wird mittels einem Knof ausgegeben\n" +
                    "  welcher Spieler beginnen kann.\n" +
                    "- Wenn dieser Knopf betätigt wurde werden die Karten des Spielers ausgegeben.\n" +
                    "\n" +
                    "Es gelten die allgemeinen MauMau Spielregeln.\n" +
                    "\n" +
                    "----------------------------- Regelung \"Ober\" ------------------------------\n" +
                    "- Falls ein \"Ober\" geschmissen wird und der Gegenspieler auch einen \"Ober\" in \n" +
                    "  seinem Kartenstapel hat, hat er die Möglichkeit, mittels einer umgedrehten \n" +
                    "  Karte in seinem Kartenstapel 2 neue Karten zu ziehen.\n" +
                    "- Falls auf die umgedrehte Karte geklickt wurde, werden 2 neue Karten gezogen,\n" +
                    "  falls auf dem \"Ober\" geklickt wurdewerden beim Gegenspieler 4 neue Karten\n" +
                    "  hinzugefügt.\n" +
                    "\n" +
                    "----------------------------- Regelung Taufen/9er ----------------------------\n" +
                    "- Grundsätzlich gilt, dass ein 9er auf jede Karte darf. Das heisst, dass man zB.\n" +
                    "  einen Herz 9er auch auf eine Schell Ass legen darf.\n" +
                    "- Zusätzlich zu dem darf man eine Farbe wählen wenn man einen 9er legt.\n" +
                    "- Nachdem man einen 9er gelegt hat erscheint um unteren Bereich der Spieleoberfläche\n" +
                    "  ein Knopf in dem beschrieben wird, dass man nochmals an der Reihe ist.\n" +
                    "- Falls dieser Knopf betätigt wurde, werden auf der linken Seite der momentan\n" +
                    "  Aufliegenden Karte die Symbole der Farben eingeblendet.\n" +
                    "- Nun kann man zwischen den verschiedenen Farben wählen und der Gegenspieler kann\n" +
                    "  nur eine Karte dieser Farbe legen.\n");
        });

        gameInfoBTN.setOnMouseEntered(actionEvent -> {
            gameInfoBTN.setStyle("-fx-background-color: #20b5d9; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
        });

        gameInfoBTN.setOnMouseExited(actionEvent -> {
            gameInfoBTN.setStyle("-fx-background-color: #41d9c4; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
        });
    }
}
