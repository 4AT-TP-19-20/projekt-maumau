package sample;



import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
//import sun.jvm.hotspot.tools.SysPropsDumper;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class ControllerPlayScreen {


    public ImageView karte;
    public Button btnImg;
    public Button btnNext;

    public ImageView newCard; // Aufliegende Karte
    public HBox spielerKarten;
    public VBox tafnBox;

    public Image image;
    public Image image2;
    public Image image3;
    public Image image4;
    public Image image5;
    public Image image6;

    public Image e = new Image(getClass().getResource("/eichel.png").toExternalForm());
    public Image h = new Image(getClass().getResource("/herz.png").toExternalForm());
    public Image s = new Image(getClass().getResource("/schell.png").toExternalForm());
    public Image l = new Image(getClass().getResource("/lab.png").toExternalForm());

    public Image back = new Image(getClass().getResource("/Karte.png").toExternalForm());

    public Button btnStart1;
    public Pane mainPane;

    private int a, b, c, d;
    private boolean startButtonActive = true;

    private static Spieler sp1;
    private static Spieler sp2;

    public void initialize() {

        //karten namen 1-32, random zahl von 1-32 generieren und dann mit to string karte anzeigen i+.jpg
        int newCardsCounter = 0;

        try {

            btnStart1.setOnMouseEntered(actionEvent -> {
                btnStart1.setStyle("-fx-background-color: #20b5d9; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
            });

            btnStart1.setOnMouseExited(actionEvent -> {
                btnStart1.setStyle("-fx-background-color: #41d9c4; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
            });

            btnStart1.setOnMouseClicked(actionEvent -> {
                sp1 = new Spieler(JOptionPane.showInputDialog("Name Spieler1:"));
                sp2 = new Spieler(JOptionPane.showInputDialog("Name Spieler2:"));
                Karte.erstelleKartenStapel();

                Spiel.teileAus(sp1, sp2);
                Spiel.kartenStapel = new ArrayList<>();
                Spiel.kartenStapel.add(Karte.getKarte());
                newCard.setImage(Spiel.kartenStapel.get(Spiel.kartenStapel.size() - 1).getImage());

                mainPane.getChildren().remove(btnStart1);
                if (Spiel.kartenStapel.get(Spiel.kartenStapel.size() - 1).getEffect() == 1) {
                    spielerWechsel(sp1, -1);
                } else {
                    spielerWechsel(sp2, Spiel.kartenStapel.get(Spiel.kartenStapel.size() - 1).getEffect());
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void spielerWechsel(Spieler sp, int effect) {
        karte.setDisable(false);
        btnNext.setVisible(false);

        spielerKarten.getChildren().removeAll(spielerKarten.getChildren());
        if (effect != 3 && effect != -1 && effect != 1) {
            if (sp == sp1) {
                sp = sp2;
            } else {
                sp = sp1;
            }
        }

        effect = (effect == 3) ? 0 : effect;

        System.out.println(sp.name + " " + effect);
        Button tempButton = new Button();
        tempButton.setText(sp.name + " ist dran!");
        Spieler finalSp = sp;
        int finalEffect = effect;
        tempButton.setOnMouseClicked(actionEvent1 -> {
            spielRunde(finalSp, finalEffect);
        });
        spielerKarten.getChildren().add(tempButton);
    }

    public void showTafn(Spieler sp) {

    }

    public void spielRunde(Spieler sp, int effect) {
        spielerKarten.getChildren().removeAll(spielerKarten.getChildren());
        if (effect > 10 && !sp.hasOber()) {
            for (int i = 0; i < effect % 10; ++i) {

            }
        } else if (effect > 10) {

            if (effect < 10) {

            }

            for (Karte k : sp.akutelleKarten) {

            }
            if (effect == -1) {
                showTafn(sp2);
            } else if (effect == 1) {
                showTafn(sp);
            }
        }

    }
}