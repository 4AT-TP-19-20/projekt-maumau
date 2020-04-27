package sample;

import javafx.scene.image.ImageView;

import javax.swing.*;
import java.util.*;


public class Spiel{

    public static boolean spielFertig=false;


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
    - Keine Karte darf doppelt sein
    - Spielregeln einbauen

     */

    public static ArrayList<Karte> kartenStapel;

    public static void spielStarten() {

        //zeigeKartenStapel();
        //erstelleSpieler();
        //teileAus();
        /*for (int i = 0; i < spieler.size(); i++) {
            schaueInKartenVonSpieler(i);
        }
        */

        //legeKarteVomStapel();
        //System.out.println("Es liegt " + liegendeKarte);
        //reihumKartenLegen();
    }

    public static void teileAus(Spieler sp1,Spieler sp2) {
        for (int i = 0;i<5;i++) {
            sp1.addKarte(Karte.getKarte());
            sp2.addKarte(Karte.getKarte());
        }
    }
}
