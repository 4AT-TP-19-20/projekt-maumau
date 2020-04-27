package sample;

import java.util.ArrayList;
import java.util.Vector;

public class Spieler {
    String name;
    ArrayList<Karte> akutelleKarten = new ArrayList<>();

    public Spieler(String name) {
        this.name = name;
    }

    public void addKarte(Karte karte) {
        if (karte != null) {
            akutelleKarten.add(karte);
        }
    }

    public boolean hasOber() {
        for (Karte k : akutelleKarten) {
            if (k.getEffect() == 11) {
                return true;
            }
        }
        return false;
    }
}