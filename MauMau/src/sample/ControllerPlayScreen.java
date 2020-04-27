package sample;



import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import javax.swing.*;
import java.util.ArrayList;

/*
    ----------SPIELREGELN-------------

    Nur gleiche Farbe auf gleicher Farbe == zB 7er Herz darf auf 10er Herz aber nicht 10er Schell
    Nur gleiche Figur auf gleiche Figur == zB 7er Herz darf auf 7er Schell aber nicht 10er Schell
    9er darf überall + darf man Farbe aussuchen == 7er Herz liegt auf, man kann zB 9er Schell drauflegen und neue Farbe ansagen
    Falls gegner Ober legt 2 neue Karten ziehen == Gegner wirft Ober, falls man keinen weiteren Ober hat kommen 2 neue Karten beim eigenen STapel hinzu


    --------T0D0------
    - Start und Play GUI Erstellen  - DONE
    - Random Karten einblenden - DONE
    - Random Karten einblenden falls Startknopf betätigt - DONE
    - Wenn man keine Karte hat, auf Kartenstapel klicken um neue Karte zu erhalten - DONE
    - Code mit Bilder verbinden, d.h. ArrayList oder ähnliches mit Bildern DONE
    - Bis jetzt wurden bei der GUI nur random Karten dargestellt ohne dokumentation welche Karten bereits verwendet wurden DONE
    - Keine Karte darf doppelt sein DONE
    - Spielregeln einbauen ONGOING

     *-1 erste runde tafn
     *
     * 0 nichts
     * 3 auslossn
     *
     * 1 tafn
     *
     * 6 herz getaft
     * 7 lab getaft
     * 8 schell getaft
     * 9 eichel getaft
     *
     * 11 2 auklaubm
     * 12 3 auklaubm
     * 13 4 auklaubm
     * 14 5 auklaubm

     */

public class ControllerPlayScreen {


    public ImageView karte;
    public Button btnImg;
    public Button btnNext;

    public ImageView newCard; // Aufliegende Karte
    public HBox spielerKarten;
    public VBox tafnBox;

    public Image e = new Image(getClass().getResource("/img/eichel.png").toExternalForm());
    public Image h = new Image(getClass().getResource("/img/herz.png").toExternalForm());
    public Image s = new Image(getClass().getResource("/img/schell.png").toExternalForm());
    public Image l = new Image(getClass().getResource("/img/lab.png").toExternalForm());

    public Image back = new Image(getClass().getResource("/img/Karte.png").toExternalForm());

    public Button btnStart1;
    public Pane mainPane;

    public static Spieler sp1;
    public static Spieler sp2;

    public static ArrayList<Karte> kartenStapel;


    public void initialize(){


        try {

            btnStart1.setOnMouseEntered(actionEvent -> {
                btnStart1.setStyle("-fx-background-color: #20b5d9; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
            });

            btnStart1.setOnMouseExited(actionEvent -> {
                btnStart1.setStyle("-fx-background-color: #41d9c4; -fx-background-insets: 1; -fx-border-color: #ffffff; -fx-border-radius: 5;");
            });

            btnStart1.setOnMouseClicked(actionEvent -> {
                sp1 = new Spieler(JOptionPane.showInputDialog(null,"Name Spieler1:"));
                sp2 = new Spieler(JOptionPane.showInputDialog(null,"Name Spieler2:"));
                Karte.erstelleKartenStapel();

                teileAus(sp1,sp2);
                kartenStapel = new ArrayList<>();
                kartenStapel.add(Karte.getKarte());
                newCard.setImage(kartenStapel.get(kartenStapel.size()-1).getImage());

                mainPane.getChildren().remove(btnStart1);
                if(kartenStapel.get(kartenStapel.size()-1).getEffect()==1){
                    spielerWechsel(sp1,-1);
                }else{
                    spielerWechsel(sp2,kartenStapel.get(kartenStapel.size()-1).getEffect());
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }


    }


    public static void teileAus(Spieler sp1,Spieler sp2) {
        for (int i = 0;i<5;i++) {
            sp1.addKarte(Karte.getKarte());
            sp2.addKarte(Karte.getKarte());
        }
    }

    public void spielerWechsel(Spieler sp, int  effect){
        karte.setDisable(false);
        btnNext.setVisible(false);

        spielerKarten.getChildren().removeAll(spielerKarten.getChildren());
        if(effect!=3 && effect!=-1 && effect!=1) {
            if (sp == sp1) {
                sp = sp2;
            } else {
                sp = sp1;
            }
        }

        effect = (effect==3)? 0 : effect;

        System.out.println(sp.name + " "+effect);
        Button tempButton = new Button();
        tempButton.setText(sp.name + " ist dran!");
        Spieler finalSp = sp;
        int finalEffect = effect;
        tempButton.setOnMouseClicked(actionEvent1 -> {
            spielRunde(finalSp, finalEffect);
        });
        spielerKarten.getChildren().add(tempButton);
    }

    public void showTafn(Spieler sp){
        //TODO
    }

    public void spielRunde(Spieler sp, int effect){
        spielerKarten.getChildren().removeAll(spielerKarten.getChildren());
        if(effect>10 && !sp.hasOber()){
            for(int i = 0; i < effect%10; ++i){
                sp.addKarte(Karte.getKarte());
                sp.addKarte(Karte.getKarte());
            }
            effect=0;
        }else if(effect>10){
            ImageView tempKarte = new ImageView(back);
            tempKarte.setPreserveRatio(true);
            tempKarte.setFitHeight(100);
            int finalEffect1 = effect;
            tempKarte.setOnMouseClicked(actionEvent1 -> {
                for(int i = 0; i < finalEffect1 %10; ++i){
                    sp.addKarte(Karte.getKarte());
                    sp.addKarte(Karte.getKarte());
                }
                spielRunde(sp,0);
            });
            spielerKarten.getChildren().add(tempKarte);
        }
        if(effect<10){
            int finalEffect2 = effect;

            karte.setOnMouseClicked(actionEvent1 -> {
                sp.addKarte(Karte.getKarte());
                spielRunde(sp,finalEffect2);
                karte.setDisable(true);
                btnNext.setVisible(true);
            });
            btnNext.setOnMouseClicked(actionEvent1 -> {
                spielerWechsel(sp, finalEffect2);
            });
        }

        for(Karte k : sp.akutelleKarten){
            ImageView tempKarte = new ImageView(k.getImage());
            tempKarte.setPreserveRatio(true);
            tempKarte.setFitHeight(100);

            final int[] finalEffect = {effect};
            tempKarte.setOnMouseClicked(actionEvent1 -> {
                if(finalEffect[0] <6){
                    if((k.getFarbe() == kartenStapel.get(kartenStapel.size()-1).getFarbe() || k.getSymbol() == kartenStapel.get(kartenStapel.size()-1).getSymbol() || k.getEffect() == 1 ) ){
                        kartenStapel.add(k);
                        sp.akutelleKarten.remove(k);
                        newCard.setImage(k.getImage());
                        if(sp.akutelleKarten.size()<1){

                            Main.PRIMARYSTAGE.setTitle("MauMau");
                            Main.PRIMARYSTAGE.setScene(new Scene(Main.rootEndScreen, 843, 534));
                            Main.PRIMARYSTAGE.show();
                        }else{
                            spielerWechsel(sp,k.getEffect());
                        }
                    }
                }else if (finalEffect[0] <11){
                    if( (finalEffect[0] ==6 && k.getFarbe()=="h" ) || ( finalEffect[0] ==7 && k.getFarbe()=="l" ) || ( finalEffect[0] ==8 && k.getFarbe()=="s" ) || ( finalEffect[0] ==9 && k.getFarbe()=="e" ) || k.getEffect() == 1){
                        kartenStapel.add(k);
                        sp.akutelleKarten.remove(k);
                        newCard.setImage(k.getImage());
                        if(sp.akutelleKarten.size()<1){

                            Main.PRIMARYSTAGE.setTitle("MauMau");
                            Main.PRIMARYSTAGE.setScene(new Scene(Main.rootEndScreen, 843, 534));
                            Main.PRIMARYSTAGE.show();


                            //JOptionPane.showMessageDialog(null,sp.name+" hat gewonnen!");
                        }else {
                            spielerWechsel(sp, k.getEffect());
                        }
                    }
                }else{
                    if(  k.getEffect() == 11){
                        kartenStapel.add(k);
                        sp.akutelleKarten.remove(k);
                        newCard.setImage(k.getImage());
                        if(sp.akutelleKarten.size()<1){

                            Main.PRIMARYSTAGE.setTitle("MauMau");
                            Main.PRIMARYSTAGE.setScene(new Scene(Main.rootEndScreen, 843, 534));
                            Main.PRIMARYSTAGE.show();

                        }else {
                            spielerWechsel(sp, finalEffect[0]++);
                        }
                    }
                }
            });

            spielerKarten.getChildren().add(tempKarte);
        }
        if(effect==-1){
            showTafn(sp2);
        }else if(effect==1){
            showTafn(sp);
        }
    }

}