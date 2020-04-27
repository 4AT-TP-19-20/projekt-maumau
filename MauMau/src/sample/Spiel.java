package sample;

import java.util.Iterator;
import java.util.Random;
import java.util.Vector;


public class Spiel{

    public static String[] FARBEN = new String[]{"Herz", "Laub", "Eiche", "Shell"};
    public static String[] WERTE = new String[]{"Ass", "König", "Ober", "Unter", "10", "9", "8", "7"};
    public boolean spielFertig=false;


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
    - Code mit Bilder verbinden, d.h. ArrayList oder ähnliches mit Bildern
    - Bis jetzt wurden bei der GUI nur random Karten dargestellt ohne dokumentation welche Karten bereits verwendet wurden
    - Keine Karte darf doppelt sein
    - Spielregeln einbauen

     */



    Random rndm = new Random(System.currentTimeMillis());
    Vector<Karte> kartenStapel;

    void spielStarten() {
        erstelleKartenStapel();
        mischeKartenStapel();
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

    void erstelleKartenStapel() {
        kartenStapel = new Vector<Karte>();
        for (int i = 0; i < FARBEN.length; i++) {
            for (int j = 0; j < WERTE.length; j++) {
                kartenStapel.add(new Karte(FARBEN[i], WERTE[j]));
            }
        }
    }

    void zeigeKartenStapel() {
        System.out.println("Kartenstapel:");
        Iterator<Karte> iterator = kartenStapel.iterator();
        while (iterator.hasNext()) {
            Karte karte = iterator.next();
            System.out.println(karte);
        }
    }

    void mischeKartenStapel() {
        for (int i = 0; i < 1000; i++) {
            int tauschPartner1 = rndm.nextInt(32);
            int tauschPartner2 = rndm.nextInt(32);
            Karte karte1 = kartenStapel.get(tauschPartner1);
            Karte karte2 = kartenStapel.get(tauschPartner2);
            kartenStapel.setElementAt(karte2, tauschPartner1);
            kartenStapel.setElementAt(karte1, tauschPartner2);
        }
    }

    void zieheKarte(Spieler spieler) {
        spieler.akutelleKarten.add(kartenStapel.firstElement());
        kartenStapel.removeElementAt(0);
    }

    public void nachsterSpieler(){
        //spieler++
    }


    public void karteLegen(){
        // azsgewählte karte
    }
}
